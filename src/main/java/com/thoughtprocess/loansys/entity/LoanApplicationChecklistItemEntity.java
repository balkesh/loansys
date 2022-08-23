package com.thoughtprocess.loansys.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "LoanApplicationChecklistItem")
@Data
public class LoanApplicationChecklistItemEntity {

    @EmbeddedId
    private LoanApplicationChecklistId applicationChecklistId;

    @Column(name = "iscomplete" , nullable = false, length = 1)
    private Boolean isComplete;

    @Column(name = "notes", length = 1000, nullable = true)
    private String notes;
}
