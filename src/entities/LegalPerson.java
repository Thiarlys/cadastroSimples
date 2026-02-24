package entities;

import java.time.LocalDateTime;

public class LegalPerson extends Person{
    private String legalName;

    public LegalPerson(Integer id, String address, LocalDateTime createdAt, String legalName) {
        super(id, address, createdAt);
        if (legalName == null || legalName.trim().length() < 3) {
            throw new IllegalArgumentException("Invalid legal name.");
        }
        this.legalName = legalName;
    }

    public void update(String newLegalName, String newAddress) {
        if (legalName == null || legalName.trim().length() < 3) {
            throw new IllegalArgumentException("Invalid legal name.");
        }
        this.legalName = newLegalName;
        super.update(newAddress);
    }


    @Override
    public String toString() {
        return "----Legal person----" + "\n" +
                "Legal name: " + this.legalName + "\n" +
                super.toString();
    }
}
