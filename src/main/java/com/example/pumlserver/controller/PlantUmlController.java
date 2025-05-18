package com.example.pumlserver.controller;

import com.example.pumlserver.service.PlantUmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/puml")
public class PlantUmlController {

    private final PlantUmlService plantUmlService;

    @Autowired
    public PlantUmlController(PlantUmlService plantUmlService) {
        this.plantUmlService = plantUmlService;
    }

    @PostMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateDiagram(@RequestBody String plantUmlCode) {
        try {
            byte[] imageBytes = plantUmlService.generateDiagram(plantUmlCode);
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(imageBytes);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
} 