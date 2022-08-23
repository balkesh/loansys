package com.thoughtprocess.loansys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplicationResponseDto {
    private Integer loanApplicationId;
    private String applicantName;
    private String status;
}
