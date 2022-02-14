package ru.job4j.design.srp;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employees")
public class Employees {

    private List<Employees> list;

    public List<Employees> getList() {
        return list;
    }

    public void setList(List<Employees> list) {
        this.list = list;
    }

}
