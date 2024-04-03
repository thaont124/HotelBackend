package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TypeRoomUtility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTypeRoomUtility;

    @ManyToOne
    @JoinColumn(name = "type_room_id", referencedColumnName = "idTypeRoom")
    private TypeRoom typeRoom;
    @ManyToOne
    @JoinColumn(name = "utility_id", referencedColumnName = "idUtility")
    private Utility utility;
}
