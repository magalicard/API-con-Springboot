package com.edteam.demo.dao.imp;

import com.edteam.demo.dao.ImageDao;
import com.edteam.demo.models.Image;
import com.edteam.demo.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class ImageDaoImp implements ImageDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<Image> getAll() {
        String hql = "FROM Image as i";
        return entityManager.createQuery(hql, Image.class).getResultList();
    }

    @Override
    public Image get(long id) {
        return entityManager.find(Image.class, id);
    }

    @Override
    public Image add(Image image) {
        entityManager.persist(image);
        return image;
    }

    @Override
    public void delete(long id) {
        Image image = get(id);
        if (image != null) {
            entityManager.remove(image);
        }
    }
}
