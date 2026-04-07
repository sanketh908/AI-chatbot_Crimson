package com.sanketh.chatbot.Repository;

import com.sanketh.chatbot.Entity.ResetTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResetTokenEntityRepository extends JpaRepository<ResetTokenEntity, Integer> {
}
