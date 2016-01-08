package _06_GenericsAndCollections;

import java.util.Arrays;

class _6_24_ComparatorTest {
    public static void main(String []args) {
        _6_24_Student[]students = {  new _6_24_Student("cs011", "Lennon  ", 3.1),
        new _6_24_Student("cs021", "McCartney", 3.4),
        new _6_24_Student("cs012", "Harrison ", 2.7),
        new _6_24_Student("cs022", "Starr ", 3.7) };

        System.out.println("Before sorting by CGPA ");
        System.out.println("_6_23_Student-ID \t  Name \t  CGPA (for 4.0) ");
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, new _6_24_CGPAComparator());

        System.out.println("After sorting by CGPA");
        System.out.println("_6_23_Student-ID \t  Name \t  CGPA (for 4.0) ");
        System.out.println(Arrays.toString(students));
    }
}