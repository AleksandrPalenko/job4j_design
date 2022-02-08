package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;
import java.util.Comparator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportHRTest {

    @Test
    public void whenOldGeneratedHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(Comparator.comparingDouble(Employee::getSalary)).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}