package com.sanketh.chatbot.Repository;

import com.sanketh.chatbot.Entity.PromptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PromptRepository extends JpaRepository<PromptEntity,Long> {
    @Modifying
    @Query("delete from ChatEntity c where c.chatId = :id")
    int deleteChatById(@Param("id") Long id);
}
