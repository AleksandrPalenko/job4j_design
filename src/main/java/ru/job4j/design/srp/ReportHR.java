package ru.job4j.design.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportHR implements Report {
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary");
        List<Employee> list = store.findBy(filter);
        list.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(list).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
