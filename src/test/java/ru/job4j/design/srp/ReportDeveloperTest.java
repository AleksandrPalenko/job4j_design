package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportDeveloperTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2017, Calendar.FEBRUARY , 25);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append(" <html> "
                        + "<head> "
                        + "<title>Name; Hired; Fired; Salary;</title> "
                        + "</head> "
                        + "<body> ")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}