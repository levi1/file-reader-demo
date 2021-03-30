package com.example.file_reader.document;

import com.example.file_reader.helper.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository repository;

    public void save(MultipartFile file){
        List<DocumentData> data;
        try {
            data = CSVHelper.csvToDocumentData(file.getInputStream(), repository);
            repository.saveAll(data);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store csv data: " + e.getMessage());
        }
    }

    public List<DocumentData> getAllData(){
        return repository.findAll();
    }

}
