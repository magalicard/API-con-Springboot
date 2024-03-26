package com.edteam.demo.dao;

import com.edteam.demo.models.Image;

import java.util.List;

public interface ImageDao {
    List<Image> getAll();
    Image get(long id);
    Image add(Image image);
    void delete(long id);



}
