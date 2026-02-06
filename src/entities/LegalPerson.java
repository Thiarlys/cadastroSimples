package entities;

import java.time.LocalDateTime;

public class LegalPerson extends Person{
    private String legalName;

    public LegalPerson(Integer id, String address, LocalDateTime createdAt, String legalName) {
        super(id, address, createdAt);
        this.legalName = legalName;
    }

    public void update(String newLegalName, String newAddress) {
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
