package Admission.Duytea.controller.sort;

import java.util.Comparator;
import Admission.Duytea.model.Subject;


public class SortSubjectByNameDESC implements Comparator<Subject> {

    @Override
    public int compare(Subject o1, Subject o2) {
        return o2.getName().compareTo(o1.getName());
    }
    
}