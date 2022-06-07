package repository;

import model.Furniture;
import model.Video;

import java.util.List;

public interface FurnitureRepository {
    List<Furniture> getAllFurniture();
    void save(Furniture furniture);
    Furniture findById(Long serial);
}
