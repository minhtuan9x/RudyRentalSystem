package repository.impl;

import model.Video;
import repository.VideoRepository;
import util.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;


public class VideoRepositoryImpl implements VideoRepository {
    private final EntityManager entityManager = JpaUtils.getEntityManagerFactory().createEntityManager();

    public List<Video> getAllVideo() {
        Query query = entityManager.createQuery("from Video", Video.class);
        return query.getResultList();
    }

    @Override
    public void save(Video video) {
        entityManager.getTransaction().begin();
        try {
            if (Objects.isNull(video.getSerialNumber()))
                entityManager.persist(video);
            else
                entityManager.merge(video);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Video findById(Long serial) {
        Query query = entityManager.createQuery("from Video v where v.serialNumber = " + serial, Video.class);
        try {
            return (Video) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Not found");
            return null;
        }

    }


}
