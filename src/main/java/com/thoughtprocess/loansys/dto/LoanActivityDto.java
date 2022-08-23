package com.thoughtprocess.loansys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanActivityDto {
    @NotNull(message = "loanApplicationId cannot be null")
    @NotEmpty(message = "loanApplicationId cannot be empty")
    @Pattern(regexp = "[0-9]",message = "loanApplicationId must be in number format")
    private Integer loanApplicationId;

    @NotNull(message = "checkListTask cannot be null")
    @NotEmpty(message = "checkListTask cannot be empty")
    @Pattern(regexp = "[a-zA-Z]", message = "checkListTask must be alphabet")
    private String checkListTask;

    @NotNull(message = "isComplete cannot be null")
    @NotEmpty(message = "isComplete cannot be empty")
    private Boolean isComplete;

    private String notes;
}
