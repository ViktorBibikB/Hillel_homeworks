package my.exceptions;

import java.sql.SQLException;

public class HomeWorkDoesNotExistsException extends SQLException {
    public HomeWorkDoesNotExistsException(String reason, String sqlState, Throwable cause){
        super(reason, sqlState, cause);
    }

    public HomeWorkDoesNotExistsException(String reason){
        super(reason);
    }
}
