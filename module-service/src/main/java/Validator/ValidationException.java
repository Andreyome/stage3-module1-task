package Validator;

public class ValidationException extends RuntimeException{
    public ValidationException(String string){
        super(string);
    }
}
