package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    Config config = new Config("app.properties");
    String url = config.value("url");
    String login = config.value("login");
    String password = config.value("password");

    public TableEditor(Properties properties) throws ClassNotFoundException, SQLException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName(config.value("driver_class"));
        config.load();
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws SQLException, ClassNotFoundException {
        initConnection();
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(tableName);
            }
        }

    public void dropTable(String tableName) throws SQLException, ClassNotFoundException {
        initConnection();
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(tableName);
            }
        }

    public void addColumn(String tableName, String columnName, String type) throws SQLException, ClassNotFoundException {
        initConnection();
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(tableName);
                statement.execute(columnName);
                statement.executeQuery(type);
            }
        }

    public void dropColumn(String tableName, String columnName) throws SQLException, ClassNotFoundException {
        initConnection();
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(tableName);
                statement.execute(columnName);
            }
        }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException, ClassNotFoundException {
        initConnection();
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(tableName);
                statement.execute(columnName);
                statement.execute(newColumnName);
            }
        }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}