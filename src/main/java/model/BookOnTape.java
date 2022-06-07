package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "bookontape")
public class BookOnTape extends Thing {
    private String category;

    public BookOnTape(){}
    public BookOnTape(Long serialNumber, String name, Double rentCost, String category) {
        super(serialNumber, name, rentCost);
        this.category = category;
    }

    public BookOnTape(String category) {
        this.category = category;
    }

    @Override
    public String getDescription() {
        return super.toString() + String.format("%-20s",this.category);
    }
}
