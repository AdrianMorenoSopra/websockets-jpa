package com.example.websockets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.websockets.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
