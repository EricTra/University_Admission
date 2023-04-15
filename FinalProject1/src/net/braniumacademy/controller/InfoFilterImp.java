package net.braniumacademy.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.braniumacademy.exception.InvalidDateOfBirthException;
import net.braniumacademy.exception.InvalidEmailException;
import net.braniumacademy.exception.InvalidNameException;
import net.braniumacademy.exception.InvalidPersonIdException;
import net.braniumacademy.exception.InvalidPhoneNumberException;
import net.braniumacademy.exception.InvalidStudentIdException;


public class InfoFilterImp implements InforFilter {

    @Override
    public boolean isStudentIdValid(String id) throws InvalidStudentIdException {
        //  3 chữ cái viết hoa và tiếp theo là 6 chữ số
        var regex = "^[A-Z]{3}\\\\d{6}$"; 
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(id);
        if(matcher.matches()) {
            return true;
        } else {
            var msg = "Mã sinh viên không hợp lệ: " + id;
            throw new InvalidStudentIdException(id, msg);
        }
    }

    @Override
    public boolean isPersonIdValid(String id) throws InvalidPersonIdException {
        var regex = "^(^\\d{12}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(id);
        if(matcher.matches()) {
            return true;
        } else {
            //chuỗi chứa đúng 12 chữ số
            var msg = "Số CMND/Căn cước không hợp lệ: " + id;
            throw new InvalidPersonIdException(id, msg);
        }
    }

    @Override
    public boolean isNameValid(String name) throws InvalidNameException {
        var regex = "^([a-zA-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠ"
                + "ỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ]+\\s?){2,30}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | 
                Pattern.CANON_EQ | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(name);
        if(matcher.matches()) {
            return true;
        } else {
            var msg = "Họ tên không hợp lệ: " + name;
            throw new InvalidNameException(name, msg);
        }
    }
    //        //"^": Bắt đầu của chuỗi.
//"(": Bắt đầu của nhóm các ký tự. Nhóm này chứa:
//"[a-zA-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ]+": Một hoặc nhiều chữ cái tiếng Việt và chữ cái tiếng Anh viết hoa hoặc viết thường.
//"\s?": Không hoặc một ký tự khoảng trắng.
//")": Kết thúc của nhóm các ký tự. Nhóm này có thể lặp lại từ 2 đến 30 lần.
//"$": Kết thúc của chuỗi.

    @Override
    public boolean isEmailValid(String email) throws InvalidEmailException {
        var regex = "^[a-z]+[a-z0-9._]*@gmail.com$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()) {
            return true;
        } else {
            var msg = "Email không hợp lệ: " + email;
            throw new InvalidEmailException(email, msg);
        }
    }
//    ^: Đây là ký tự bắt đầu của regular expression và đại diện cho vị trí bắt đầu của chuỗi.
//[a-z]+: Phần này đại diện cho tên đăng nhập email bắt đầu bằng một hoặc nhiều ký tự chữ cái thường (a-z).
//[a-z0-9.]*: Đây là phần tiếp theo của tên đăng nhập và có thể chứa bất kỳ số lượng nào (bao gồm cả không có) các ký tự sau: chữ cái thường (a-z), chữ số (0-9), dấu chấm (.) và dấu gạch dưới ().
//@gmail.com: Đây là phần domain của email, và chỉ chấp nhận địa chỉ email của Google với domain là "gmail.com".
//$: Đây là ký tự kết thúc của regular expression và đại diện cho vị trí kết thúc của chuỗi.

    @Override
    public boolean isPhoneNumberValid(String phoneNumber) 
            throws InvalidPhoneNumberException {
        var regex = "^(03|04|07|08|09)\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if(matcher.matches()) {
            return true;
        } else {
            var msg = "Số điện thoại không hợp lệ: " + phoneNumber;
            throw new InvalidPhoneNumberException(phoneNumber, msg);
        }
    }

    @Override
    public boolean isDateOfBirthValid(String dobString) 
            throws InvalidDateOfBirthException {
        var regex = "^\\d{2}/\\d{2}/\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dobString);
        if(matcher.matches()) {
            return true;
        } else {
            var msg = "Ngày sinh không hợp lệ: " + dobString;
            throw new InvalidDateOfBirthException(dobString, msg);
        }
    }
    
}
