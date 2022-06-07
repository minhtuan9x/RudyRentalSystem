package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "furniture")
public class Furniture extends Thing{
    @Override
    public String getDescription() {
        return null;
    }
}
