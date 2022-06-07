package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "furniture")
public class Furniture extends Thing {
    private String madeIn;
    public Furniture(){}

    public Furniture(Long serialNumber, String name, Double rentCost, String madeIn) {
        super(serialNumber, name, rentCost);
        this.madeIn = madeIn;
    }

    public Furniture(String madeIn) {
        this.madeIn = madeIn;
    }

    @Override
    public String getDescription() {
        return super.toString() + String.format("%-20s",this.madeIn);
    }
}
