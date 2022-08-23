package com.thoughtprocess.loansys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplicationChecklistId implements Serializable {

    private static final long serialVersionUID = -7113809628847183488L;
    @Column(name = "loanapplicationid",nullable = false)
    private Integer loanApplicationId;

    @NotNull
    @Column(name = "checklisttask", nullable = false,length = 50)
    private String checkListTask;
}