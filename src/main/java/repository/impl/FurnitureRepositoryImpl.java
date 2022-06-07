package repository.impl;

import model.Furniture;
import model.Video;
import repository.FurnitureRepository;
import util.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


public class FurnitureRepositoryImpl implements FurnitureRepository {
    private final EntityManager entityManager = JpaUtils.getEntityManagerFactory().createEntityManager();

    @Override
    public List<Furniture> getAllFurniture() {
        Query query = entityManager.createQuery("from Furniture ", Furniture.class);
        return query.getResultList();
    }

    @Override
    public void save(Furniture furniture) {
        try {
            if (Objects.isNull(furniture.getSerialNumber()))
                entityManager.persist(furniture);
            else
                entityManager.merge(furniture);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Furniture findById(Long serial) {
        Query query = entityManager.createQuery("from Furniture v where v.serialNumber = " + serial, Furniture.class);
        try {
            return (Furniture) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Not Found");
            return null;
        }

    }
}
