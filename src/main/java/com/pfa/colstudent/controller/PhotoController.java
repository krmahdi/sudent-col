package com.pfa.colstudent.controller;

import com.pfa.colstudent.model.Photo;
import com.pfa.colstudent.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth/photo")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @GetMapping
    public List<Photo> getAllAnnonces(){return this.photoService.getAll();}
    @GetMapping("/{id}")
    public ResponseEntity<Photo> findById(@PathVariable Long id) {
        Optional<Photo> optionalPhoto = photoService.findById(id);
        if (optionalPhoto.isPresent()) {
            Photo photo = optionalPhoto.get();
            return new ResponseEntity<>(photo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity addPhoto(@RequestBody Photo photo) {
        return ResponseEntity.ok(this.photoService.addPhoto(photo));
    }
    @DeleteMapping("/{id}")
    public void deletePhoto(@PathVariable("id") Long Id){this.photoService.deletePhotoById(Id);}
    @PutMapping
    private Photo udpdatePhoto(@RequestBody Photo photo) {
        photoService.updatePhoto(photo);
        return photo;
    }
}