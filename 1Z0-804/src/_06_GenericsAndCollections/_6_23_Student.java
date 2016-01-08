package _06_GenericsAndCollections;

// This program shows the usage of Comparable interface

class _6_23_Student implements Comparable<_6_23_Student> {
    String id;
    String name;
    Double cgpa;

    public _6_23_Student(String studentId, String studentName, double studentCGPA) {
        id = studentId;
        name = studentName;
        cgpa = studentCGPA;
    }

    public String toString() {
return " \n " + id + "  \t  " + name + "  \t  " + cgpa;
}

    public int compareTo(_6_23_Student that) {
        return this.id.compareTo(that.id);
    }
}
 
