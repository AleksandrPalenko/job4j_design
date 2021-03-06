package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportDeveloper implements Report {
    private Store store;

    public ReportDeveloper(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html> "
                        + "<head> "
                        + "<title>Name; Hired; Fired; Salary;</title> "
                        + "</head> "
                        + "<body> ")
                .append(System.lineSeparator()).append("<td>");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append("</td><td>")
                    .append(employee.getHired()).append("</td><td>")
                    .append(employee.getFired()).append("</td><td>")
                    .append(employee.getSalary()).append("</td><td>")
                    .append(System.lineSeparator());
        }
        text.append("</body>");
        text.append("</html>");
        return text.toString();
    }
}