package com.g11.LanguageLearn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class PhotoFeedback extends Photo{
    @ManyToOne
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    public PhotoFeedback(String uri, String type, Feedback feedback) {
        super(uri, type);
        this.feedback = feedback;
    }
}
