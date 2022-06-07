package model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class Thing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serialNumber;
    private String name;
    private Double rentCost;

    public Thing(Long serialNumber, String name, Double rentCost) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.rentCost = rentCost;
    }

    public Thing() {

    }

    public abstract String getDescription();

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s", this.serialNumber, this.name, this.rentCost);
    }
}
