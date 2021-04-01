package com.example.file_reader.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class DocumentController {

    @Autowired
    DocumentService documentService;


    @GetMapping("/")
    public String showUploadPage() {
        return "index";
    }


    @PostMapping("/upload")
    public String uploadCsv(@RequestParam("file")MultipartFile file){
        documentService.save(file);
        return "redirect:/";
    }

    @GetMapping("/sales")
    @ResponseBody
    public ResponseEntity<List<DocumentData>> getAllData(){
        return new ResponseEntity<>(documentService.getAllData(), HttpStatus.OK);
    }

    @GetMapping("/sale/{orderId}")
    @ResponseBody
    public ResponseEntity<DocumentData> getDocumentData(@PathVariable long orderId){
        return new ResponseEntity<>(documentService.getDataByOrderId(orderId), HttpStatus.OK);
    }


}
