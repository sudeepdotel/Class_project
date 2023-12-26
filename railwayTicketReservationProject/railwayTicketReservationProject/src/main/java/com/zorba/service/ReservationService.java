package com.zorba.service;

import com.zorba.MainApplication;
import com.zorba.model.RailwayReservastion;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.zorba.daoo.ReservationDao.insertIntoDatabase;
import static com.zorba.daoo.ReservationDao.updateSeniorCitizenStatus;

public class ReservationService {

    public static void addReservation( Scanner scanner, Logger logger) {

        List<RailwayReservastion> reservationList = new ArrayList<>();
        System.out.println("Welcome to the Reservation portal:");
        System.out.println("Enter your passenger name:");
        String passengerName = scanner.next();

        int passengerAge;
        boolean isSeniorCitizen = false;
        while (true) {
            try {
                System.out.println("Enter passenger Age:");
                passengerAge = scanner.nextInt ();
                if (passengerAge <= 0) {
                    logger.error ( new NumberFormatException () );
                    throw new NumberFormatException();
                }

                if (passengerAge > 60) {
                    isSeniorCitizen = true;
                   // System.out.println("Passenger is a senior citizen. Given lower berth/seat");
                    logger.info ( "Passenger is a senior citizen. Given lower berth/seat" );
                }
                break;
            } catch (NumberFormatException e) {
               // System.out.println("Invalid input. Please enter a valid age as a positive integer.");
                logger.error ( e.getStackTrace () );
            }
        }

        System.out.println("Enter seat type (economy/business):");
        String chosenSeat = scanner.next();

        if(isSeniorCitizen){
            chosenSeat = "Lower seat";
        }

        System.out.println("Enter preference (AC/Non-AC):");
        String reservationType = scanner.next();


        double amountPaid;
        if ("AC".equalsIgnoreCase(reservationType)) {
            amountPaid = 100.0;
        } else {
            amountPaid = 60.0;
        }


        RailwayReservastion reservation = new RailwayReservastion();
        reservation.setPassengerName(passengerName);
        reservation.setPassengerAge(passengerAge);
        reservation.setChosenSeat(chosenSeat);
        reservation.setTypeOfReservation(reservationType);
        reservation.setSeniorCitizen(isSeniorCitizen);
        reservation.setAmountPaid(amountPaid);

        logger.info ( reservation.toString () );

        reservationList.add(reservation);
        logger.info ( "successfully added the reservation for the user !!" );
        // insert into the database
        insertIntoDatabase(reservation,logger);
        logger.info ( "successfully inserted data into databases!!" );

        // update the database according to the passenger age
        updateSeniorCitizenStatus(passengerAge,logger);
        logger.info ( " Successfully updated the status for the reservation!!!" );

    }
}
