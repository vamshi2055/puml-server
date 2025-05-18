package com.example.pumlserver.service;

import net.sourceforge.plantuml.SourceStringReader;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PlantUmlService {

    public byte[] generateDiagram(String plantUmlCode) throws IOException {
        SourceStringReader reader = new SourceStringReader(plantUmlCode);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        reader.generateImage(outputStream);
        return outputStream.toByteArray();
    }
} 