package com.edteam.demo.services;

import com.edteam.demo.dao.ImageDao;
import com.edteam.demo.models.Image;
import com.edteam.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ImageService {

    @Autowired
    ImageDao imageDao;

    public List<Image> getAll() {
        return imageDao.getAll();
    }

    public Image get(long id) {
        return imageDao.get(id);
    }

    public void add(Image image){
        // Crea una nueva instancia de Image
        Image newImage = new Image();
        newImage.setNombre(image.getNombre());
        newImage.setTipo(image.getTipo());
        newImage.setTamano(image.getTamano());
        newImage.setPixel(image.getPixel());
        // Genera un UUID y lo establece en la imagen
        UUID uuid = UUID.randomUUID();
        newImage.setUuid(UUID.fromString(uuid.toString()));
        // Llama al método add con la nueva instancia
        imageDao.add(newImage);

    }
    public void delete(long id) {
        imageDao.delete(id);
    }


}
