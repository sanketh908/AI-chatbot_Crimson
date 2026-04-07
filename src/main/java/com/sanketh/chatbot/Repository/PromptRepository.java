package com.sanketh.chatbot.Repository;

import com.sanketh.chatbot.Entity.PromptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromptRepository extends JpaRepository<PromptEntity,Long> {
}
