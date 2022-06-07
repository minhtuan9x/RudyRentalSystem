package model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "video")
public class Video extends Thing{
    @Override
    public String getDescription() {
        return null;
    }

    public String toString() {
        return super.toString();
    }

}
