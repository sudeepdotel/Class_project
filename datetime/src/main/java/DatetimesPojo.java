import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DatetimesPojo {

    private int id;
    public LocalDateTime datetime;

    public int getId ( ) {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public LocalDateTime getDatetime ( ) {
        return datetime;
    }

    public void setDatetime ( LocalDateTime datetime ) {
        this.datetime = datetime ;
    }



}
