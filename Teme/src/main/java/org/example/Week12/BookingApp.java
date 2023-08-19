package org.example.Week12;

import java.sql.*;

public class BookingApp {
    public void createTable(Connection connection) {
        String accommodationTable = "CREATE TABLE accommodation (" +
                "id INT PRIMARY KEY," +
                "type VARCHAR(32)," +
                "bed_type VARCHAR(32)," +
                "max_guests INT," +
                "description VARCHAR(512))";

        String roomFairTable = "CREATE TABLE room_fair (" +
                "id INT PRIMARY KEY," +
                "value double precision," +
                "season VARCHAR(32))";

        String relationTable = "CREATE TABLE accommodation_room_fair_relation (" +
                "id INT PRIMARY KEY," +
                "accommodation_id INT," +
                "room_fair_id INT," +
                "FOREIGN KEY (accommodation_id) REFERENCES accommodation(id)," +
                "FOREIGN KEY (room_fair_id) REFERENCES room_fair(id))";
        try (PreparedStatement statement1 = connection.prepareStatement(accommodationTable);
             PreparedStatement statement2 = connection.prepareStatement(roomFairTable);
             PreparedStatement statement3 = connection.prepareStatement(relationTable)) {
            statement1.executeUpdate();
            statement2.executeUpdate();
            statement3.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertData(Connection connection) {
        String insertAccommodation = "INSERT INTO accommodation (id, type, bed_type, max_guests, description) VALUES (?, ?, ?, ?, ?)";
        String insertRoomFair = "INSERT INTO room_fair (id, value, season) VALUES (?, ?, ?)";
        String insertRelation = "INSERT INTO accommodation_room_fair_relation (id, accommodation_id, room_fair_id) VALUES (?, ?, ?)";

        try (PreparedStatement stmtAccommodation = connection.prepareStatement(insertAccommodation);
             PreparedStatement stmtRoomFair = connection.prepareStatement(insertRoomFair);
             PreparedStatement stmtRelation = connection.prepareStatement(insertRelation)) {

            stmtAccommodation.setInt(1, 1);
            stmtAccommodation.setString(2, "Standard");
            stmtAccommodation.setString(3, "Single bed");
            stmtAccommodation.setInt(4, 1);
            stmtAccommodation.setString(5, "Single bed room.");
            stmtAccommodation.executeUpdate();

            stmtRoomFair.setInt(1, 1);
            stmtRoomFair.setDouble(2, 100.90);
            stmtRoomFair.setString(3, "peak season");
            stmtRoomFair.executeUpdate();

            stmtRelation.setInt(1, 1);
            stmtRelation.setInt(2, 1);
            stmtRelation.setInt(3, 1);
            stmtRelation.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void roomPrice(Connection connection) {
        String selectPrices = "SELECT value FROM room_fair;";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectPrices);
            while (resultSet.next()) {
                System.out.println(resultSet.getDouble("value"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
