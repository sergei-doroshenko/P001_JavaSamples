package _06_GenericsAndCollections;

// This program shows the implementation of Comparator interface

import java.util.Comparator;

class _6_24_CGPAComparator implements Comparator<_6_24_Student> {

    public int compare(_6_24_Student s1, _6_24_Student s2) {
return (s1.cgpa.compareTo(s2.cgpa));     
}    
}
