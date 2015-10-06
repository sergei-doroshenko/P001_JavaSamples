package core._3_io._1_io.adapter;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by Sergei on 06.03.2015.
 */
public class EntityDataInput implements EntityIntput {
    private final DataInputStream in;

    public EntityDataInput(DataInputStream in) {
        this.in = in;
    }

    @Override
    public Person readPerson() throws IOException {
        String name = in.readBoolean() ? in.readUTF() : null;

        int age = in.readInt();

        Person.Sex[] sex = null;
        if (in.readBoolean()) {
            int len = in.readInt();
            sex = new Person.Sex[len];
            for (int i = 0; i < sex.length; i++) {
                byte sexByte = in.readByte();
                sex[i] = sexByte == 0 ? null : (sexByte == 0 ? Person.Sex.F : Person.Sex.M);
            }
        }


        return new Person(name, age, sex);
    }

    @Override
    public void close() throws IOException {
        in.close();
    }
}
