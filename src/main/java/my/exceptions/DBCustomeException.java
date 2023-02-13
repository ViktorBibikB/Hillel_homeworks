package my.exceptions;

import java.sql.SQLException;

public class DBCustomeException extends Exception {

    public DBCustomeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DBCustomeException(String message){
        super(message);
    }

}
