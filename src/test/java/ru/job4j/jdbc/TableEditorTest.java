package ru.job4j.jdbc;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.Assert.*;

public class TableEditorTest {

    @Test
    public void whenCreateTable() throws Exception {
        FileInputStream file = new FileInputStream("app.properties");
        Properties pr = new Properties();
        pr.load(file);
        TableEditor tableEditor = new TableEditor(pr);
        tableEditor.createTable("Program");
        tableEditor.close();
    }

    @Test
    public void whenDropTable() throws Exception {
        FileInputStream file = new FileInputStream("app.properties");
        Properties pr = new Properties();
        pr.load(file);
        TableEditor tableEditor = new TableEditor(pr);
        tableEditor.dropTable("Program");
        tableEditor.close();
    }

    @Test
    public void whenAddColumn() throws Exception {
        FileInputStream file = new FileInputStream("app.properties");
        Properties pr = new Properties();
        pr.load(file);
        TableEditor tableEditor = new TableEditor(pr);
        tableEditor.addColumn("Program", "users", "varchar(255)");
        tableEditor.close();
    }

    @Test
    public void whenRenameColumn() throws Exception {
        FileInputStream file = new FileInputStream("app.properties");
        Properties pr = new Properties();
        pr.load(file);
        TableEditor tableEditor = new TableEditor(pr);
        tableEditor.renameColumn("Program", "users", "superuser");
        tableEditor.close();
    }

    @Test
    public void whenDropColumn() throws Exception {
        FileInputStream file = new FileInputStream("app.properties");
        Properties pr = new Properties();
        pr.load(file);
        TableEditor tableEditor = new TableEditor(pr);
        tableEditor.dropColumn("Program", "superuser");
        tableEditor.close();
    }
}