package com.zorba;

import com.zorba.daoo.ReservationDao;
import com.zorba.model.RailwayReservastion;
import com.zorba.service.ReservationService;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class MainApplication {

    static Logger log = Logger.getLogger ( "generalLogger ");

    static  Logger errorLog = Logger.getLogger ( "errorLogger");
    static Logger successLog = Logger.getLogger ( "successLogger");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ReservationService.addReservation (scanner, errorLog);
        log.info("Successfully added");
        errorLog.error ( "not okay" );
        successLog.info ( "successfully !!!!" );

        scanner.close();
    }
}
