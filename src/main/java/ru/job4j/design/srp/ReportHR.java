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
        List<Employee> list = store.findBy(filter);
        list.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        text.append("Name;Salary")
                .append(System.lineSeparator());
        for (Employee employee : list) {
            text.append(employee.getName()).append(";")
                    .append(System.lineSeparator())
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
