package dev.jrn.exam_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.jrn.exam_system.entity.MessageSample;
import dev.jrn.exam_system.repository.MessageSampleRepository;

@Service
public class MessageSampleService {
    
    @Autowired
    private MessageSampleRepository messageSampleRepository;

    public String getMessageTemplate(String key) {
        return messageSampleRepository.getTemplateByKey(key);
    }

    public void updateTemplate(String text, String key) {
        MessageSample ms = messageSampleRepository.getMessageSampleByKey(key);
        ms.setText_sample(text);
    }
}
