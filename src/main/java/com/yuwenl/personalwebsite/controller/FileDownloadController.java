package com.yuwenl.personalwebsite.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.http.MediaType;

@RestController
public class FileDownloadController {

    private final Path fileStorageLocation;

    public FileDownloadController() {
         this.fileStorageLocation = Paths.get("/home/azureuser/documents").toAbsolutePath().normalize();
//        this.fileStorageLocation = Paths.get("/Users/yuwen/Desktop").toAbsolutePath().normalize();
    }

    @GetMapping("/download-resume")
    public ResponseEntity<Resource> downloadResume() {
        try {
            Path filePath = this.fileStorageLocation.resolve("Resume_Yuwen_Lu.pdf").normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_PDF)
                        .header("Content-Disposition", "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}




