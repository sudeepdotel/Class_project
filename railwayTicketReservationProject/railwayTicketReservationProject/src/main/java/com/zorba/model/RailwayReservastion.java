package com.zorba.model;

public class RailwayReservastion {

    private String passengerName;
    private int passengerAge;
    private String chosenSeat;
    private String typeOfReservation;
    private double amountPaid;
    private boolean isSeniorCitizen;

    public RailwayReservastion() {
    }
     public String getPassengerName() {
        return passengerName;
    }
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
    public int getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(int passengerAge) {
        this.passengerAge = passengerAge;
    }

    public String getChosenSeat() {
        return chosenSeat;
    }

    public void setChosenSeat(String chosenSeat) {
        this.chosenSeat = chosenSeat;
    }

    public String getTypeOfReservation() {
        return typeOfReservation;
    }

    public void setTypeOfReservation(String typeOfReservation) {
        this.typeOfReservation = typeOfReservation;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public boolean isSeniorCitizen() {
        return isSeniorCitizen;
    }

    public void setSeniorCitizen(boolean seniorCitizen) {
        isSeniorCitizen = seniorCitizen;
    }

}
