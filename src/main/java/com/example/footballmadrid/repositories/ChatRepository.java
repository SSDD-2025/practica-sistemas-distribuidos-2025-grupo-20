package com.example.footballmadrid.repositories;

import com.example.footballmadrid.models.ChatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatModel, Long> {
}
