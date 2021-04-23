package com.example.file_reader.helper;

import com.example.file_reader.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BackgroundService {

    @Autowired
    DocumentService documentService;


    @Scheduled(fixedRate = 20000)
    public void checkForFilesAndUpload(){
        documentService.checkForFilesAndSave();
    }

}
