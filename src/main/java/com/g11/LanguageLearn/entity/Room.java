package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRoom;

    private String roomNumber;

    private Float pricePerDay;

    private Float pricePerHour;

    @ManyToOne
    @JoinColumn(name = "type_room_id", referencedColumnName = "idTypeRoom")
    private TypeRoom typeRoom;

    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "idBranch")
    private Branch branch;

}
