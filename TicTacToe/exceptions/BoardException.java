package exceptions;

public class BoardException extends RuntimeException {
    public BoardException(String exceptinMessage){
        super(exceptinMessage);
    }

    BoardException(){}
}
