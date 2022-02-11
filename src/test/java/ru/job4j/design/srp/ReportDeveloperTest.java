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
        Calendar now = new GregorianCalendar(2017, Calendar.FEBRUARY, 25);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportDeveloper engine = new ReportDeveloper(store);
        StringBuilder expect = new StringBuilder()
                .append("<html> "
                        + "<head> "
                        + "<title>Name; Hired; Fired; Salary;</title> "
                        + "</head> "
                        + "<body> ")
                .append(System.lineSeparator()).append("<td>")
                .append(worker.getName()).append("</td><td>")
                .append(worker.getHired()).append("</td><td>")
                .append(worker.getFired()).append("</td><td>")
                .append(worker.getSalary()).append("</td><td>")
                .append(System.lineSeparator())
                .append("</body>")
                .append("</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}