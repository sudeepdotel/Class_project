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


Sorry I forgot this part please consider this !!

Part – A:

1. Which of the following is advantage of using JDBC connection pool?
   A) Slow performance
   B) Using more memory
   C) Using less memory
   D) Better performance
   ans: D


2. Which of the following is advantage of using PreparedStatement in Java?
   A) Slow performance
   B) Encourages SQL injection
   C) Prevents SQL injection
   D) More memory usage
   ans: B


3. What does setAutoCommit(false) do?
   A) commits transaction after each query
   B) explicitly commits transaction
   C) does not commit transaction automatically after each query
   D) never commits transaction
   ans: C

4. Which of the following is used to rollback a JDBC transaction?
   A) rollback()
   B) rollforward()
   C) deleteTransaction()
   D) RemoveTransaction()
   ans: A

5.  Select the packages in which JDBC classes are defined?
   A) jdbc and javax.jdbc
   B) rdb and javax.rdb
   C) jdbc and java.jdbc.sql
   D) sql and javax.sql
   ans: C


6. What is the correct sequence to create a database connection?
   i. Import JDBC packages.
   ii. Open a connection to the database.
   iii. Load and register the JDBC driver.
   iv. Execute the statement object and return a query resultset.
   v. Create a statement object to perform a query.
   vi. Close the resultset and statement objects.
   vii. Process the resultset.
   A) i, ii, iii, v, iv, vii, viii, vi
   B) i, iii, ii, v, iv, vii, vi, viii
   C) ii, i, iii, iv, viii, vii, v, vi
   D) i, iii, ii, iv, v, vi, vii, viii
   ans: A


7. Which of the following method is used to perform DML statements in JDBC?
   A) executeResult()
   B) executeQuery()
   C) executeUpdate()
   D) execute()
   ans: C

8. Which methods are required to load a database driver in JDBC?
   A) getConnection()
   B) registerDriver()
   C) forName()
   D) Both b and c
   ans: A


9. Parameterized queries can be executed by?
   A) ParameterizedStatement
   B) PreparedStatement
   C) CallableStatement and ParameterizedStatement
   D) All kinds of Statements
   ans: D

10. What should be the correct order to close the database resource? What should
    be the correct order to close the database resource?
    A) Connection, Statements, and then ResultSet
    B) ResultSet, Connection, and then Statements
    C) Statements, ResultSet, and then Connection
    D) ResultSet, Statements, and then Connection
    ans: D 

