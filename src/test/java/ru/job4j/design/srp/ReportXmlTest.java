package ru.job4j.design.srp;

import org.junit.Test;

import java.time.OffsetDateTime;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportXmlTest {

    @Test
    public void whenXMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        OffsetDateTime date = OffsetDateTime.ofInstant(now.toInstant(), now.getTimeZone().toZoneId());
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportXml engine = new ReportXml(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<employees>\n")
                .append("    <employees ")
                .append("name=\"").append(worker.getName()).append("\"")
                .append(" hired=\"")
                .append(date).append("\"")
                .append(" fired=\"")
                .append(date).append("\"")
                .append(" salary=\"")
                .append(worker.getSalary()).append("\"/>").append("\n")
                .append("</employees>\n");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}