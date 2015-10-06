package core._3_io._1_io.adapter;

import java.io.*;

/**
 * Created by Sergei on 06.03.2015.
 */
public class AdapterApp {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/person.dat");

        EntityOutput edo = new EntityDataOutput(new DataOutputStream(new FileOutputStream(file)));
        edo.writePerson(new Person("Mike", 46, new Person.Sex[] {Person.Sex.F, null}));
        edo.flush();
        edo.close();

        EntityIntput edi = new EntityDataInput(new DataInputStream(new FileInputStream(file)));
        Person p0 = edi.readPerson();
        edi.close();
        System.out.println(p0);
    }
}
