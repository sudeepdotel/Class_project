package com.zorba;

import com.zorba.daoo.ReservationDao;
import com.zorba.model.RailwayReservastion;
import com.zorba.service.ReservationService;

import java.util.List;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ReservationService.addReservation (scanner);

        scanner.close();
    }
}
