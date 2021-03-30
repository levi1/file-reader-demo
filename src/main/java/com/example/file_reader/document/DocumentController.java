package com.example.file_reader.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DocumentController {

    @Autowired
    DocumentService documentService;


    @GetMapping("/")
    public String showUploadPage() {
        return "index";
    }


    @PostMapping("/")
    public String uploadCsv(@RequestParam("file")MultipartFile file){
        documentService.save(file);
        return "redirect:/";
    }


}
