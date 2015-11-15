package _06_GenericsAndCollections.Listing_6_24;

// This program shows the implementation of Comparator interface

import java.util.Comparator;

class CGPAComparator implements Comparator<Student> {

    public int compare(Student s1, Student s2) {
return (s1.cgpa.compareTo(s2.cgpa));     
}    
}
