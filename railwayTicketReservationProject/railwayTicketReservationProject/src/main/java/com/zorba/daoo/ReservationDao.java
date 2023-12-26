package com.zorba.daoo;

import com.zorba.MainApplication;
import com.zorba.model.RailwayReservastion;
import com.zorba.utils.DbConnection;
import org.apache.log4j.Logger;

import java.sql.*;


public class ReservationDao {

    private static final String INSERT_SQL_QUERY = "INSERT INTO reservations (passenger_name, passenger_age, chosen_seat, reservation_type,is_senior_citizen, amount_paid) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL_QUERY = "UPDATE reservations SET is_senior_citizen = ? WHERE passenger_age = ?";

    public static void insertIntoDatabase ( RailwayReservastion reservation , Logger log) {
        try (Connection connection = DbConnection.getConnection (log)) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL_QUERY)) {
                preparedStatement.setString(1, reservation.getPassengerName());
                preparedStatement.setInt(2, reservation.getPassengerAge());
                preparedStatement.setString(3, reservation.getChosenSeat());
                preparedStatement.setString(4, reservation.getTypeOfReservation ());
                preparedStatement.setBoolean(5, reservation.isSeniorCitizen());
                preparedStatement.setDouble(6, reservation.getAmountPaid());


                int rowsAffected = preparedStatement.executeUpdate ();
                if (rowsAffected > 0) {
                    //System.out.println("Record inserted successfully into the database.");
                    log.info ( "Record inserted successfully into the database." );


                } else {
                    //System.out.println("Failed to insert record into the database.");
                    log.info ( "Failed to insert record into the database." );
                }
            }
        } catch (Exception e) {
            log.error ( e.getStackTrace ());
        }
    }


    public static void updateSeniorCitizenStatus(int passengerAge, Logger logger) {
        try (Connection connection = DbConnection.getConnection(logger)) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL_QUERY)) {
                preparedStatement.setInt(1, (passengerAge > 60) ? 1 : 0);
                preparedStatement.setInt(2, passengerAge);


                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    //System.out.println("Senior citizen status updated successfully in the database.");
                    logger.info ( "Senior citizen status updated successfully in the database." );
                } else {
                   // System.out.println("Failed to update senior citizen status in the database.");
                    logger.info ( "Senior citizen status updated successfully in the database." );
                }
            }
        } catch (Exception e) {
            logger.error ( e.getStackTrace () );

        }
    }

}

