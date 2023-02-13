package my.exceptions;

import java.sql.SQLException;

public class LessonDoesNotExistsException extends SQLException {
    public LessonDoesNotExistsException(String reason, String sqlState, Throwable cause){
        super(reason, sqlState, cause);
    }

    public LessonDoesNotExistsException(String reason){
        super(reason);
    }


    public LessonDoesNotExistsException(String reason, String sqlState){
        super(reason, sqlState);
    }
}
