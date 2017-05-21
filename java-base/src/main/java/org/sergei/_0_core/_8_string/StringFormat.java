package org.sergei._0_core._8_string;

/**
 * Created by Sergei_Doroshenko on 2/22/2017.
 */
public class StringFormat {
    public static void main(String[] args) {
        Long id = Long.valueOf("1024");
        System.out.println(String.format("This is long: '%d'", id.longValue()));
        System.out.println(new String(new byte[]{0x49, 0x4D, 0x41, 0x47, 0x45}));
        System.out.println(new String(new byte[]{73, 77, 65, 71, 69}));
        System.out.println(new String(new byte[]{34, 83, 85, 49, 66, 82, 48, 85, 61, 34}));
        // %2$d
        String message01 = String.format(
                "Unexpected exception on assignment job save. Assignment id: %1$s, AwsHit id: %2$d ",
                "KSJKF839033938DJDLDJFJ", 203L
        );
        System.out.println(message01);


    }
}
