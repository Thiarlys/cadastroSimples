package entities;

import java.time.LocalDateTime;
import java.util.Scanner;

public class LegalPerson extends Person{
    private String legalName;

    public LegalPerson() {
    }


    public LegalPerson(Integer id, String address, LocalDateTime createdAt, String legalName) {
        super(id, address, createdAt);
        validateLegalName(legalName);
        this.legalName = legalName;
    }

    public void update(String newLegalName, String newAddress) {
        validateLegalName(newLegalName);
        this.legalName = newLegalName;
        super.update(newAddress);
    }

    public static void validateLegalName(String legalName) {
        if (legalName == null || legalName.trim().isEmpty()) {
            System.out.println("------------------");
            throw new IllegalArgumentException("Invalid legal name.");
        }
    }


    @Override
    public String toString() {
        return "----Legal person----" + "\n" +
                "Legal name: " + this.legalName + "\n" +
                super.toString();
    }
}
