package net.braniumacademy.exception;


public class InvalidNameException extends Exception {

    private String invalidName;

    public InvalidNameException() {
    }

    public InvalidNameException(String invalidName, String message) {
        super(message);
        this.invalidName = invalidName;
    }

    public String getInvalidName() {
        return invalidName;
    }

    public void setInvalidName(String invalidName) {
        this.invalidName = invalidName;
    }
}
