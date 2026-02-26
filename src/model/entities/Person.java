package model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public abstract class Person {
    protected Integer id;
    protected String address;
    protected LocalDateTime createdAt;
    protected LocalDateTime updateAt;

    public Person() {
    }

    public Person(Integer id, String address, LocalDateTime createdAt) {
        this.id = id;
        this.address = address;
        this.createdAt = createdAt;
        this.updateAt = createdAt;
    }

    public Integer getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    protected void update(String address) {
        this.address = address;
        this.updateAt = LocalDateTime.now();
    }





    public String toString() {
        return "ID: " + this.id + "\n" +
                "Address: " + this.address + "\n" +
                "Created at: " + this.createdAt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + "\n" +
                "Update at: " + this.updateAt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}

