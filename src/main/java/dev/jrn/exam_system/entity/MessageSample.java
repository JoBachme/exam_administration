package dev.jrn.exam_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notification_sample")
public class MessageSample {

    @Id
    private String notification_name;
    private String text_sample;

    public MessageSample() {
    }

    public MessageSample(String notification_name, String text_sample) {
        this.notification_name = notification_name;
        this.text_sample = text_sample;
    }

    public String getNotification_name() {
        return notification_name;
    }

    public void setNotification_name(String notification_name) {
        this.notification_name = notification_name;
    }

    @Override
    public String toString() {
        return "MessageSample [notification_name=" + notification_name + ", text=" + text_sample + "]";
    }

    public String getText_sample() {
        return text_sample;
    }

    public void setText_sample(String text_sample) {
        this.text_sample = text_sample;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((notification_name == null) ? 0 : notification_name.hashCode());
        result = prime * result + ((text_sample == null) ? 0 : text_sample.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MessageSample other = (MessageSample) obj;
        if (notification_name == null) {
            if (other.notification_name != null)
                return false;
        } else if (!notification_name.equals(other.notification_name))
            return false;
        if (text_sample == null) {
            if (other.text_sample != null)
                return false;
        } else if (!text_sample.equals(other.text_sample))
            return false;
        return true;
    }

    

}
