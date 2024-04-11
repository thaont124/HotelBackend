package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFeedback;

    private Integer rate;

    private String content;

    @OneToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "idBill")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "idBranch")
    private Branch branch;
}
