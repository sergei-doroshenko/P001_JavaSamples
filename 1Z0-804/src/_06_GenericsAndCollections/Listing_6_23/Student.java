package _06_GenericsAndCollections.Listing_6_23;

// This program shows the usage of Comparable interface

import com.sun.istack.internal.NotNull;

class Student implements Comparable<Student> {
    String id;
    String name;
    Double cgpa;

    public Student(String studentId, String studentName, double studentCGPA) {
        id = studentId;
        name = studentName;
        cgpa = studentCGPA;
    }

    public String toString() {
return " \n " + id + "  \t  " + name + "  \t  " + cgpa;
}

    public int compareTo(Student that) {
        return this.id.compareTo(that.id);
    }
}
 
