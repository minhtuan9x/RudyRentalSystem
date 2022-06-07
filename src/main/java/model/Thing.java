package model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class Thing {
    @Id
    private Long serialNumber;
    private String name;
    private Double rentCost;
    public abstract String getDescription();

    @Override
    public String toString() {
        return "Thing{" +
                "serialNumber=" + serialNumber +
                ", name='" + name + '\'' +
                ", rentCost=" + rentCost +
                '}';
    }
}
