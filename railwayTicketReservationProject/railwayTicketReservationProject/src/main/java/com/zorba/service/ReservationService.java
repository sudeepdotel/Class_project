package com.zorba.service;

import com.zorba.model.RailwayReservastion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.zorba.daoo.ReservationDao.insertIntoDatabase;
import static com.zorba.daoo.ReservationDao.updateSeniorCitizenStatus;

public class ReservationService {

    public static void addReservation( Scanner scanner) {

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
                    throw new NumberFormatException();
                }

                if (passengerAge > 60) {
                    isSeniorCitizen = true;
                    System.out.println("Passenger is a senior citizen. Given lower berth/seat");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid age as a positive integer.");
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


        reservationList.add(reservation);

        // insert into the database
        insertIntoDatabase(reservation);

        // update the database according to the passenger age
        updateSeniorCitizenStatus(passengerAge);

    }
}
