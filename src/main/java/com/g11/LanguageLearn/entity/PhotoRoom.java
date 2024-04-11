package com.g11.LanguageLearn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class PhotoRoom extends Photo{
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
