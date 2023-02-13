package my.exceptions;

import java.sql.SQLException;

public class DublicatedHomeWorkIDException extends SQLException {
    public DublicatedHomeWorkIDException(String reason, String SQLState) {
        super(reason, SQLState);
    }

    public DublicatedHomeWorkIDException(String reason) {
        super(reason);
    }
}
