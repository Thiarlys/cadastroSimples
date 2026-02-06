package entities;

import java.time.LocalDateTime;

public class NaturalPerson extends Person{

    private String name;
    private Integer age;

    public NaturalPerson(Integer id, String address, LocalDateTime createdAt, String name, Integer age) {
        super(id, address, createdAt);
        this.name = name;
        this.age = age;
    }

    public void update(String newName, Integer newAge, String newAddress) {
        this.name = newName;
        this.age = newAge;
        super.update(newAddress);
    }

    @Override
    public String toString() {
        return "----Natural person----" + "\n" +
                "Name: " + this.name + "\n" +
                "Age: " + this.age + "\n" +
                super.toString();
    }
}
