package com.example.footballmadrid.Repositories;

import com.example.footballmadrid.Models.ChatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatModel, Integer> {
}
