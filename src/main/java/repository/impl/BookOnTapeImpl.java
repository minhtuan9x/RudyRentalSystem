package repository.impl;

import model.BookOnTape;
import repository.BookOnTapeRepository;
import util.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;


public class BookOnTapeImpl implements BookOnTapeRepository {
    private final EntityManager entityManager = JpaUtils.getEntityManagerFactory().createEntityManager();

    @Override
    public List<BookOnTape> getAllBookOnTape() {
        Query query = entityManager.createQuery("from BookOnTape ", BookOnTape.class);
        return query.getResultList();
    }

    @Override
    public void save(BookOnTape bookOnTape) {

        try {
            entityManager.getTransaction().begin();
            if (Objects.isNull(bookOnTape.getSerialNumber()))
                entityManager.persist(bookOnTape);
            else
                entityManager.merge(bookOnTape);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public BookOnTape findById(Long serial) {
        Query query = entityManager.createQuery("from BookOnTape v where v.serialNumber = " + serial, BookOnTape.class);
        try {
            return (BookOnTape) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Not found");
            return null;
        }
    }


}
