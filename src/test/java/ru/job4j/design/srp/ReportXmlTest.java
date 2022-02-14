package ru.job4j.design.srp;

import org.junit.Ignore;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportXmlTest {

    @Ignore
    @Test
    public void whenXMLGenerate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String dateTime = simpleDateFormat.format(now.getTime());
        store.add(worker);
        ReportXml engine = new ReportXml(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("\n<employees>")
                .append("\n<fired>").append(dateTime).append("</fired>")
                .append("\n<hired>").append(dateTime).append("</hired>")
                .append("\n<name>").append(worker.getName()).append("</fired>")
                .append("\n<salary>").append(worker.getSalary()).append("</fired>")
                .append("\n</employees>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}