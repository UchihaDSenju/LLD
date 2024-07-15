package exception;

public class ParkingException extends RuntimeException{
    public ParkingException(String exceptionMessage){
        super(exceptionMessage);
    }

    public ParkingException(){}
}
