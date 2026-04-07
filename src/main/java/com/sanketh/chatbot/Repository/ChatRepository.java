package com.sanketh.chatbot.Repository;

import com.sanketh.chatbot.DTO.ChatRequest;
import com.sanketh.chatbot.Entity.ChatEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity,Long> {


}
