package com.example.file_reader.document;

import com.example.file_reader.helper.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository repository;
    @Value("${upload.file.location}")
    private String uploadDirectory;

    public void save(MultipartFile file){
        try {
            save(file.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("Failed to store csv data: " + e.getMessage());
        }
    }

    public void save(InputStream inputStream){
        List<DocumentData> data;
        data = CSVHelper.csvToDocumentData(inputStream, repository);
        repository.saveAll(data);
    }

    public void checkForFilesAndSave(){
        try (Stream<Path> files = Files.walk(Paths.get(uploadDirectory))) {
            files.forEach(file-> {
                try {
                    save(new FileInputStream(file.toString()));
                    Files.delete(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("Failed to store csv data: " + e.getMessage());
        }
    }

    public DocumentData getDataByOrderId(long orderId){
        return repository.findByOrderId(orderId).orElse(null);
    }

    public List<DocumentData> getAllData(){
        return repository.findAll();
    }

}
