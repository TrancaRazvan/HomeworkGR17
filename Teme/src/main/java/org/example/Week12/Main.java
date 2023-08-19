package org.example.Week12;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        BookingApp bookingApp = new BookingApp();
        try {
            DriverManager.setLoginTimeout(60);
            String url = new StringBuilder()
                    .append("jdbc:")
                    .append("postgresql")
                    .append("://")
                    .append("localhost")
                    .append(":")
                    .append(5432)
                    .append("/")
                    .append("BookingApp")
                    .append("?user=")
                    .append("postgres")
                    .append("&password=")
                    .append("razvan").toString();

            try (Connection connection = DriverManager.getConnection(url)) {

                bookingApp.createTable(connection);
                bookingApp.insertData(connection);
                bookingApp.roomPrice(connection);

            } catch (SQLException e) {
                System.out.println("Cannot connect to the database.");
            }

        } catch (RuntimeException e) {
            System.out.println("CANNOT LOAD DRIVER");
        }
    }
}
