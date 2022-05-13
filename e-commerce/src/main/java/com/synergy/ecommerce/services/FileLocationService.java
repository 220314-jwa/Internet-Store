package com.synergy.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.google.cloud.storage.Blob;
import com.synergy.ecommerce.entities.Image;
import com.synergy.ecommerce.repositories.CloudRepository;
import com.synergy.ecommerce.repositories.FileSystemRepository;
import com.synergy.ecommerce.repositories.ImageRepository;

@Service
public class FileLocationService {

	
	@Autowired
    FileSystemRepository fileSystemRepository;
    
	@Autowired
    ImageRepository imageRepository;

    public Long save(byte[] bytes, String imagePath,String imageName) throws Exception {
      //  String location = fileSystemRepository.save(bytes, imageName);
    	  Blob location = CloudRepository.uploadObject("e-commerce", "internetstore",imageName , imagePath);
        return imageRepository.save(new Image(imageName, location.getName()))
            .getId();
    }
    
    public FileSystemResource find(Long imageId) {
        Image image = imageRepository.findById(imageId)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return fileSystemRepository.findInFileSystem(image.getLocation());
    }
}
