package sd.crypt;

import javax.crypto.*;
import java.io.*;
import java.security.*;

/**
 * Created by Sergei on 20.04.2015.
 */
public class AESTest {

    private Cipher cipher;

    public AESTest() throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance("AES");
    }

    public void generateKey(String fileName) throws NoSuchAlgorithmException, IOException {
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        SecureRandom random = new SecureRandom();
        keygen.init(random);
        SecretKey key = keygen.generateKey();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(key);
        out.close();
    }

    public Key getKey (String fileName) throws IOException, ClassNotFoundException {
        /*ObjectInputStream keyIn = null;
        try {
            keyIn = new ObjectInputStream(new FileInputStream("key.txt"));
            Key key = (Key) keyIn.readObject();
            return key;
        } finally {
            if (keyIn != null) {
                keyIn.close();
            }
        }*/
        try (ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Key) keyIn.readObject();
        }
    }

    public void encrypt (String plainFile, String secretFile)
            throws IOException, ClassNotFoundException, GeneralSecurityException {

        Key key = getKey("key.txt");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        try (InputStream in = new FileInputStream(plainFile);
            OutputStream out = new FileOutputStream(secretFile) ){
            Util.crypt(in, out, cipher);
        }

    }

    public void decrypt (String secretFile, String decryptedFile)
            throws IOException, ClassNotFoundException, GeneralSecurityException {

        Key key = getKey("key.txt");
        cipher.init(Cipher.DECRYPT_MODE, key);

        try (InputStream in = new FileInputStream(secretFile);
             OutputStream out = new FileOutputStream(decryptedFile) ){
            Util.crypt(in, out, cipher);
        }
    }

    public static void main(String[] args) {
        try {
            AESTest aes = new AESTest();
            aes.generateKey("key.txt");
            aes.encrypt("plain.txt", "secret.txt");
            aes.decrypt("secret.txt", "decrypted.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
