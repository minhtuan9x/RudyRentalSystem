package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "bookontape")
public class BookOnTape extends Thing{
    @Override
    public String getDescription() {
        return null;
    }
}
