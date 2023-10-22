package dev.jrn.exam_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.jrn.exam_system.entity.MessageSample;

@Repository
public interface MessageSampleRepository extends JpaRepository<MessageSample, String> {
    
    @Query(value = "SELECT n.text_sample FROM notification_sample n WHERE n.notification_name=?1", nativeQuery = true)
    public String getTemplateByKey(String key);

    @Query(value = "SELECT * FROM notification_sample n WHERE n.notification_name=?1", nativeQuery = true)
    public MessageSample getMessageSampleByKey(String key);

}
