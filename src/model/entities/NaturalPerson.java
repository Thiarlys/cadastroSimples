package model.entities;

import java.time.LocalDateTime;

public class NaturalPerson extends Person{

    private String name;
    private Integer age;

    public NaturalPerson() {
    }


    public NaturalPerson(Integer id, String address, LocalDateTime createdAt, String name, Integer age) {
        super(id, address, createdAt);
        validateName(name);
        validateAge(age);
        this.name = name;
        this.age = age;
    }

    public void update(String newName, Integer newAge, String newAddress) {
        validateName(newName);
        validateAge(newAge);
        this.name = newName;
        this.age = newAge;
        super.update(newAddress);
    }

    public static void validateName(String name) {
        if ((name == null) || !name.matches("[a-zA-ZÀ-ÿ ]+")) {
            System.out.println("------------------");
            throw new IllegalArgumentException("Invalid name");
        }
    }

    public static void validateAge(int age) {
        if (age <= 0 || age > 120) {
            System.out.println("------------------");
            throw new IllegalArgumentException("Invalid age");
        }
    }



    @Override
    public String toString() {
        return "----Natural person----" + "\n" +
                "Name: " + this.name + "\n" +
                "Age: " + this.age + "\n" +
                super.toString();
    }
}
