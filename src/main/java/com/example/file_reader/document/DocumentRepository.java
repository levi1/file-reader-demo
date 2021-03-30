package com.example.file_reader.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentData, Long> {
    Optional<DocumentData> findByOrderId(long orderId);
}
