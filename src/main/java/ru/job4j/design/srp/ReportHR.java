package ru.job4j.design.srp;

import java.util.Comparator;
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
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(Comparator.comparingDouble(Employee::getSalary)).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
