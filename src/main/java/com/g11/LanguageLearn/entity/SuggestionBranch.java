package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SuggestionBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSuggestionBranch;

    @ManyToOne
    @JoinColumn(name = "suggestion_id", referencedColumnName = "idSuggestion")
    private Suggestion suggestion;
    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "idBranch")
    private Branch branch;
}
