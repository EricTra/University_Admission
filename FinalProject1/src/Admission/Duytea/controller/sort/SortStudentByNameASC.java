package Admission.Duytea.controller.sort;

import java.util.Comparator;
import Admission.Duytea.model.Student;


public class SortStudentByNameASC implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
    
}
