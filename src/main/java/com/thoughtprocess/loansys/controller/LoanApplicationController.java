package com.thoughtprocess.loansys.controller;


import com.thoughtprocess.loansys.dto.LoanActivityDto;
import com.thoughtprocess.loansys.dto.LoanApplicationResponseDto;
import com.thoughtprocess.loansys.dto.enums.StatusEnum;
import com.thoughtprocess.loansys.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class LoanApplicationController {

    @Autowired
    private LoanService loanService;

    private final  String STATUS = StatusEnum.APPROVED.name();

    @GetMapping(value = "/loans")
    public ResponseEntity<List<LoanApplicationResponseDto>> fetchLoanApplication(
            @RequestParam("applicantName") @NotNull final String applicantName,
            @RequestParam(value = "status",defaultValue = "APPROVED") final StatusEnum status){

        return new ResponseEntity<>(loanService.fetchApplication(applicantName,status),HttpStatus.OK);
    }

    @GetMapping(value = "/loan/{loanapplicantionId}")
    public ResponseEntity<LoanApplicationResponseDto> fetchLoanApplicationByLoanApplication(
            @PathVariable(value = "loanapplicantionId") @NotNull Integer loanApplicationId) throws IllegalAccessException {
        return new ResponseEntity<>(loanService.fetchLoanApplicationByLoanApplication(loanApplicationId),HttpStatus.OK);

    }

    @PutMapping(value = "/loan/activity")
    public ResponseEntity<String> activity(@RequestBody() @Valid LoanActivityDto loanActivityDto) throws IllegalAccessException {

        return new ResponseEntity<>(loanService.activity(loanActivityDto),HttpStatus.OK);
    }

    @PatchMapping(value = "/loan/{loan}")
    public ResponseEntity<LoanApplicationResponseDto> statusupdate(@PathVariable("loan") Integer loan, @RequestParam("status") String status) throws IllegalAccessException {
        return new ResponseEntity<>(loanService.status(loan,status),HttpStatus.OK);

    }
}
