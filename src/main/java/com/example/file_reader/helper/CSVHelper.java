package com.example.file_reader.helper;

import com.example.file_reader.document.DocumentData;
import com.example.file_reader.document.DocumentRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CSVHelper {

    public static List<DocumentData> csvToDocumentData(InputStream is, DocumentRepository documentRepository) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withTrim().withFirstRecordAsHeader())) {

            List<DocumentData> data = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                long orderId = Long.parseLong(csvRecord.get(6));

                Optional<DocumentData> documentDataOptional = documentRepository.findByOrderId(orderId);
                DocumentData entry = new DocumentData(
                        csvRecord.get(0),
                        csvRecord.get(1),
                        csvRecord.get(2),
                        csvRecord.get(3),
                        csvRecord.get(4),
                        LocalDate.parse(csvRecord.get(5), DateTimeFormatter.ofPattern("M/d/yyyy")),
                        Long.parseLong(csvRecord.get(6)),
                        LocalDate.parse(csvRecord.get(7), DateTimeFormatter.ofPattern("M/d/yyyy")),
                        csvRecord.get(8),
                        csvRecord.get(9),
                        csvRecord.get(10),
                        csvRecord.get(11),
                        csvRecord.get(12),
                        csvRecord.get(13)
                );

                documentDataOptional.ifPresent(documentData -> entry.setId(documentData.getId()));

                data.add(entry);
            }

            return data;
        } catch (IOException e) {
            throw new RuntimeException("failed to parse CSV file: " + e.getMessage());
        }
    }

}
