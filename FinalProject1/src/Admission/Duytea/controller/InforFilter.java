package Admission.Duytea.controller;

import Admission.Duytea.exception.InvalidDateOfBirthException;
import Admission.Duytea.exception.InvalidEmailException;
import Admission.Duytea.exception.InvalidNameException;
import Admission.Duytea.exception.InvalidPersonIdException;
import Admission.Duytea.exception.InvalidPhoneNumberException;
import Admission.Duytea.exception.InvalidStudentIdException;


public interface InforFilter {

    boolean isStudentIdValid(String id) throws InvalidStudentIdException;

    boolean isPersonIdValid(String id) throws InvalidPersonIdException;

    boolean isNameValid(String name) throws InvalidNameException;

    boolean isEmailValid(String email) throws InvalidEmailException;

    boolean isPhoneNumberValid(String phoneNumber) 
            throws InvalidPhoneNumberException;

    boolean isDateOfBirthValid(String dobString) 
            throws InvalidDateOfBirthException;
}
