import java.time.LocalDateTime;
import java.util.Scanner;

public class MainExecution {

    public static void main ( String[] args ) {
        DatetimesPojo datetime = new DatetimesPojo ();

        Scanner sc = new Scanner ( System.in );
        System.out.println ("Enter date and time (use this format 2007-12-03T10:15:30)" );
        String datetimestr = sc.next ();

        datetime.setDatetime ( LocalDateTime.parse ( datetimestr ) );

        System.out.println ( datetime.getDatetime ());
    }
}
