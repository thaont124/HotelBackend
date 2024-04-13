package com.g11.LanguageLearn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class PhotoBranch extends Photo{
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;


    public PhotoBranch(String uri, String type, Branch branch) {
        super(uri, type);
        this.branch = branch;
    }
}

