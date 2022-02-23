package ru.job4j.ood.isp;

public interface Parser {
/*
здесь необходимо разделить методы на отдельные интерфейсы, потому что если какому-то отделу нужно спарсить сайт
только в xml, то все равно придется переопределять все методы из интрерфейса Parser
 */
    void generateToXML();
    void generateToJSON();
    void generateToCSV();
}
