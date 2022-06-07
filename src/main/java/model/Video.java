package model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "video")
public class Video extends Thing {
    private Integer length;

    @Override
    public String getDescription() {
        return super.toString() + this.length;
    }

    public Video(Long serialNumber, String name, Double rentCost, Integer length) {
        super(serialNumber, name, rentCost);
        this.length = length;
    }
    public Video(){
        super();
    }

    public String toString() {
        return super.toString() + String.format("%-20s",this.length);
    }

}
