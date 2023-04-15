package Admission.Duytea.controller.sort;

import java.util.Comparator;
import Admission.Duytea.model.Subject;


public class SortSubjectByNumOfLessonASC implements Comparator<Subject> {

    @Override
    public int compare(Subject o1, Subject o2) {
        return o1.getNumOfLesson() - o2.getNumOfLesson();
    }

}
