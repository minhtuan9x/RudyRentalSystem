package repository;

import model.Video;
import util.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class VideoRepository {
    private final EntityManager entityManager = JpaUtils.getEntityManagerFactory().createEntityManager();

    public List<Video> getAllVideo() {
        Query query = entityManager.createQuery("from Video", Video.class);
        return query.getResultList();
    }
}
