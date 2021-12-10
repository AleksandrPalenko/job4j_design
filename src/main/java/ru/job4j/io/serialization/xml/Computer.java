package ru.job4j.io.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "computerTop")
@XmlAccessorType(XmlAccessType.FIELD)
public class Computer {

    private boolean isGaming;
    private int age;
    private Model model;
    private String[] statuses;

    public Computer() {

    }

    public Computer(boolean isGaming, int age, Model model, String[] statuses) {
        this.isGaming = isGaming;
        this.age = age;
        this.model = model;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Computer{"
                + "isGaming=" + isGaming
                + ", age=" + age
                + ", model=" + model
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {

        final Computer computer = new Computer(true, 1, new Model("Acer NITRO 5"),
                new String[]{"Intel core i5", "GeForce GTX 1650"});
        JAXBContext context = JAXBContext.newInstance(Computer.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(computer, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {

        }
    }

}