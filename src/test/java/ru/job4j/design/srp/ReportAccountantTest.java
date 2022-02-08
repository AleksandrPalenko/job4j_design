package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportAccountantTest {

    @Test
    public void whenGenerateAccountant() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100 * 0.073);
        store.add(worker);
        Report accountant = new ReportAccountant(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary in new inflation;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(accountant.generate(em -> true), is(expect.toString()));

    }
}