package com.thoughtprocess.loansys.entity;

import com.thoughtprocess.loansys.dto.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LoanApplication")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer loanApplicationId;

    @Column(name = "applicantname", length = 100,nullable = false)
    @NotNull
    private String applicantName;

    @Column(name="status", length = 10,nullable = false)
    @NotNull
    private String status;
}
