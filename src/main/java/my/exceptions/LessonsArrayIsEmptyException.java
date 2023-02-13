package my.exceptions;

import java.sql.SQLException;

public class LessonsArrayIsEmptyException extends SQLException {
    public LessonsArrayIsEmptyException(String reason, String sqlState, Throwable cause){
        super(reason, sqlState, cause);
    }

    public LessonsArrayIsEmptyException(String reason){
        super(reason);
    }


    public LessonsArrayIsEmptyException(String reason, String sqlState){
        super(reason, sqlState);
    }
}
