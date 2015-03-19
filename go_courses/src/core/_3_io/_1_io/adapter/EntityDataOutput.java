package core._3_io._1_io.adapter;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.BitSet;

/**
 * Created by Sergei on 06.03.2015.
 */
public class EntityDataOutput implements EntityOutput {
    private final DataOutputStream out;

    public EntityDataOutput(DataOutputStream out) {
        this.out = out;
    }

    @Override
    public void writePerson(Person person) throws IOException {
        out.writeBoolean(person.getName() != null);
        if (person.getName() != null) {
            out.writeUTF(person.getName());
        }

        out.writeInt(person.getAge());

        out.writeBoolean(person.getSex() != null);
        if (person.getSex() != null) {
            out.writeInt(person.getSex().length);
            for (Person.Sex sex : person.getSex()) {
                byte sexByte;
                if (sex == null) {
                    sexByte = 0;
                } else {
                    sexByte = (byte) (sex == Person.Sex.F ?  1 : 2);
                }
                out.writeByte(sexByte);
            }
        }


    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }

    @Override
    public void close() throws IOException {
        out.close();
    }

}
