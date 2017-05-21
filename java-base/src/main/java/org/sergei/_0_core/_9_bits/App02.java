package org.sergei._0_core._9_bits;

/**
 * Created by Sergei on 20.03.2015.
 */
public class App02 {
    public static void main(String[] args) {
        byte b0 = 7;
        byte b1 = 2;

        System.out.println(b0 & b1);
        System.out.println(b0 | b1);
        System.out.println(b0 ^ b1);
        System.out.println("********************************");

        BitIndex index = new BitIndex(false).set(19, true).set(62, true);

        System.out.println(index.get(29)); // false
        System.out.println(index.get(19)); // true
        System.out.println(index.get(61)); // true
        System.out.println(index.get(62)); // true
    }
}

class BitIndex {
    private long data = 0;

    public BitIndex(boolean allTrue) {
        this.data = allTrue ? -1 : 0;
    }

    public boolean get(int index) {
//        throw new UnsupportedOperationException();
        /*
        xxxx xxxx
        &
        0001 0000
        return bit at position
         */
        return ( data & (1 << index) ) != 0;
    }

    public BitIndex set (int index, boolean value) {
        this.data = value ? data | (1 << index) : data & ~(1 << index);
        /*if (value) {
            // change specific bit to 1
            this.data = data | (1 << index); // 0000 1000

        } else {
            // change specific bit to 0
            this.data = data & ~(1 << index); // 1111 0111
        }*/
        return this;
    }
}
