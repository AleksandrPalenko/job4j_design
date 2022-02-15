package ru.job4j.design.srp;

import org.junit.Ignore;
import org.junit.Test;

import java.time.ZoneOffset;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportXmlTest {

    @Ignore
    @Test
    public void whenXMLGenerate() {
        MemStore store = new MemStore();
        Calendar date = new GregorianCalendar(2022, Calendar.FEBRUARY, 1);
        Employee worker = new Employee("Ivan", date, date, 100);
        date.setTimeZone(TimeZone.getTimeZone(ZoneOffset.of("+3")));
        store.add(worker);
        ReportXml engine = new ReportXml(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("\n<employees>")
                .append("\n<fired>").append(date).append("</fired>")
                .append("\n<hired>").append(date).append("</hired>")
                .append("\n<name>").append(worker.getName()).append("</fired>")
                .append("\n<salary>").append(worker.getSalary()).append("</fired>")
                .append("\n</employees>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}