package com.example.websockets.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.websockets.models.Message;

/**
 * Message repository, to manage persistence of Message objects.
 * 
 * @author admoreno
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	/**
	 * Returns all the messages ordered by their date. Equivalent to SQL:
	 * {@code SELECT * FROM MESSAGE ORDER BY DATE ASC;}
	 * 
	 * @return The list of ordered messages
	 */
	List<Message> findAllByOrderByDateAsc();

}
