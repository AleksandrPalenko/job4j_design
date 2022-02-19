package ru.job4j.design.srp;

import org.junit.Test;

import java.time.ZoneOffset;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportXmlTest {

    @Test
    public void whenXMLGenerated() {
        MemStore store = new MemStore();
        Calendar date = new GregorianCalendar(2022, Calendar.FEBRUARY, 1);
        date.setTimeZone(TimeZone.getTimeZone(ZoneOffset.of("+3")));
        Employee worker = new Employee("Ivan", date, date, 100);
        store.add(worker);
        ReportXml engine = new ReportXml(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<employees>\n")
                .append("    <employees ")
                .append("name=\"").append(worker.getName()).append("\"")
                .append(" hired=\"2022-02-01T00:00:00+03:00\"")
                .append(" fired=\"2022-02-01T00:00:00+03:00\"")
                .append(" salary=\"")
                .append(worker.getSalary()).append("\"/>").append("\n")
                .append("</employees>\n");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}