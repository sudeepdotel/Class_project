1. Create one table using jdbc named: ‘railway_reservastion’ with column name as
   ‘passenger_name’, ‘paggenger_age’, ‘choosen_seat’, ‘reservation_type’,
   ‘is_senior_citizen’, ‘amount_paid’.

applied:::

create database railwayDb;

use railwayDb;
CREATE TABLE reservations(
passenger_name VARCHAR(255),
passenger_age INT,
chosen_seat VARCHAR(255),
reservation_type VARCHAR(50),
is_senior_citizen BOOLEAN,
amount_paid DOUBLE
);

RESULT BEFORE APPLYING UPDATE