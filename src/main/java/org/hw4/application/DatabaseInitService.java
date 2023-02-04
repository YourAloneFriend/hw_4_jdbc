package org.hw4.application;

import org.hw4.application.storage.DataSource;

import java.sql.SQLException;
import java.sql.Statement;

import static org.hw4.application.GetQueries.getQueries;

import static org.hw4.application.storage.DataSource.*;

public class DatabaseInitService {

    public static void main(String[] args) {
        try (Statement statement = getConnection().createStatement()) {
            for (String query : getQueries("src/sql/init_db.sql"))
                statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            closeConnection();
        }
    }
}
