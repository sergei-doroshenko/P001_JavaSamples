package sd.crypt;

import sd.rsa.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.*;

/**
 * Created by Sergei on 21.04.2015.
 */
public class RSATest {
    private static final int KEYSIZE = 512;

    public static void main(String[] args)
            throws IOException, GeneralSecurityException, ClassNotFoundException {

        generateKeys("public.key", "private.key");
        encrypt("public.key", "plain.txt", "secret1.txt");
        decrypt("private.key", "secret1.txt", "decrypt1.txt");
    }

    private static void generateKeys(String publicKeyFile, String privateKeyFile) throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator pairgen = KeyPairGenerator.getInstance("RSA");
        SecureRandom random = new SecureRandom();
        pairgen.initialize(KEYSIZE, random);
        KeyPair keyPair = pairgen.generateKeyPair();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(publicKeyFile)))
        {
            out.writeObject(keyPair.getPublic());
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(privateKeyFile)))
        {
            out.writeObject(keyPair.getPrivate());
        }
    }

    private static void encrypt(String keyFile, String plainFile, String secretFile)
            throws IOException, ClassNotFoundException, GeneralSecurityException {

        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        SecureRandom random = new SecureRandom();
        keygen.init(random);
        SecretKey key = keygen.generateKey();

        // wrap with RSA public key
        try (ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(keyFile));
             DataOutputStream out = new DataOutputStream(new FileOutputStream(secretFile));
             InputStream in = new FileInputStream(plainFile) )
        {
            Key publicKey = (Key) keyIn.readObject();
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.WRAP_MODE, publicKey);
            byte[] wrappedKey = cipher.wrap(key);
            out.writeInt(wrappedKey.length);
            out.write(wrappedKey);

            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            Util.crypt(in, out, cipher);
        }
    }

    private static void decrypt(String keyFile, String secretFile, String decryptFile)
            throws IOException, ClassNotFoundException, GeneralSecurityException {

        try (DataInputStream in = new DataInputStream(new FileInputStream(secretFile));
             ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(keyFile));
             OutputStream out = new FileOutputStream(decryptFile))
        {
            int length = in.readInt();
            byte[] wrappedKey = new byte[length];
            in.read(wrappedKey, 0, length);

            // unwrap with RSA private key
            Key privateKey = (Key) keyIn.readObject();

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.UNWRAP_MODE, privateKey);
            Key key = cipher.unwrap(wrappedKey, "AES", Cipher.SECRET_KEY);

            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);

            Util.crypt(in, out, cipher);
        }
    }

}
