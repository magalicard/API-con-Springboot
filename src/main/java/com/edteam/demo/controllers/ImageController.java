package com.edteam.demo.controllers;

import com.edteam.demo.dto.ImageResponse;
import com.edteam.demo.models.Image;
import com.edteam.demo.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
     ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Image> images = imageService.getAll(); //obtiene todas las imagenes del servicio
        model.addAttribute("images", images); // Add the list of images to the model
        return "image-list"; // Return the name of the view template (e.g., Thymeleaf template)
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> get(@PathVariable Long id) {
        Image image = imageService.get(id);
        if (image != null) {
            return new ResponseEntity<>(image, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
    @GetMapping("/{id}")
    public String getImageDetails(@PathVariable Long id, Model model) {
        Image image = imageService.get(id);
        model.addAttribute("image", image);
        return "image-details"; // Return the name of the view template
    }
*/

    /**
     *
     * El metodo uploadImages está solamente en el controller
     * y se encarga de manejar la solicitud HTTP para cargar y
     * guardar múltiples imágenes.
     */

    @PostMapping("/images")
    public ResponseEntity<?> uploadImages(@RequestHeader("Authorization") String authorization, @RequestParam("files") MultipartFile[] files) throws IOException {
        // Procesa los archivos y guarda las imágenes
        List<String> imageUuids = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                Image image = new Image();
                image.setNombre(file.getOriginalFilename());
                image.setTipo(file.getContentType());
                image.setTamano(file.getSize());
                image.setPixel(file.getBytes());

                imageService.add(image);
                imageUuids.add(String.valueOf(image.getUuid())); // Asume que Image tiene un campo uuid
            }
        }

        // Crea y devuelve la respuesta
        ImageResponse response = new ImageResponse();
        response.setData(imageUuids);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    public void add(@RequestBody Image image) {
        imageService.add(image);
    }

    @DeleteMapping("/{id}")
    public String deleteImage(@PathVariable Long id) {
        imageService.delete(id);
        return "redirect:/images"; // Redirect to the image list page
    }
}

