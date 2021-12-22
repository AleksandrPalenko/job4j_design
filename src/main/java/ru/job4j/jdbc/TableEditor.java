package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws ClassNotFoundException, SQLException {
        this.properties = properties;
        initConnection();
    }

    public TableEditor() {

    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Config config = new Config("app.properties");
        Class.forName(config.value("driver_class"));
        String url = config.value("url");
        String login = config.value("login");
        String password = config.value("password");
        config.load();
        connection = DriverManager.getConnection(url, login, password);
    }

    public void tableQuery(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public void createTable(String tableName) throws SQLException {
        String sql = String.format(
                "create table if not exists demo_table(%s, %s);",
                "id serial primary key",
                "name varchar(255)",
                tableName
        );
        tableQuery(sql);
    }

    public void dropTable(String tableName) throws SQLException {
        String sql = String.format(
                "drop table if not exists demo_table(%s, %s);",
                tableName
        );
        tableQuery(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        String sql = String.format(
                "add column if not exists demo_table(%s, %s);",
                tableName,
                columnName,
                type
        );
        tableQuery(sql);
    }

    public void dropColumn(String tableName, String columnName) throws SQLException, ClassNotFoundException {
        String sql = String.format(
                "drop column if not exists demo_table(%s, %s);",
                tableName,
                columnName
        );
        tableQuery(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException, ClassNotFoundException {
        String sql = String.format(
                "drop column if not exists demo_table(%s, %s);",
                tableName,
                columnName,
                newColumnName
        );
        tableQuery(sql);
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

    public static void main(String[] args) throws Exception {
        TableEditor tableEditor = new TableEditor();
        tableEditor.initConnection();
        tableEditor.createTable("Program");
        tableEditor.addColumn("Program", "User", "Type_User");
        tableEditor.renameColumn("Program", "User", "Users");
        tableEditor.dropColumn("Program", "User");
        tableEditor.dropTable("Program");
        System.out.println(getTableScheme(tableEditor.connection, "table"));
    }
}