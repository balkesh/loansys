package com.thoughtprocess.loansys.service;

import com.thoughtprocess.loansys.dao.LoanApplicationCheckListItemDao;
import com.thoughtprocess.loansys.dao.LoanApplicationDao;
import com.thoughtprocess.loansys.dto.LoanActivityDto;
import com.thoughtprocess.loansys.dto.LoanApplicationResponseDto;
import com.thoughtprocess.loansys.dto.enums.StatusEnum;
import com.thoughtprocess.loansys.entity.LoanApplicationChecklistId;
import com.thoughtprocess.loansys.entity.LoanApplicationChecklistItemEntity;
import com.thoughtprocess.loansys.entity.LoanApplicationEntity;
import com.thoughtprocess.loansys.mapper.LoanApplicationMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanApplicationDao loanApplicationDao;



    @Autowired
    private LoanApplicationCheckListItemDao loanApplicationCheckListItemDao;


    private final LoanApplicationMapper mapper = Mappers.getMapper(LoanApplicationMapper.class);


    public List<LoanApplicationResponseDto> fetchApplication(String applicantName, StatusEnum status) {
        return mapper.toDto(loanApplicationDao.findByApplicantNameAndStatus(applicantName,status.name()));
    }

    public LoanApplicationResponseDto fetchLoanApplicationByLoanApplication(Integer loanApplicationId) throws IllegalAccessException {
        Optional<LoanApplicationEntity> loanApplicationEntity = loanApplicationDao.findById(loanApplicationId);
        if (!loanApplicationEntity.isPresent()){
            throw new IllegalAccessException("Entry does not exists");
        }
        return  mapper.convertToDto(loanApplicationEntity.get());
    }

    public String activity(LoanActivityDto loanActivityDto) throws IllegalAccessException {
        Optional<LoanApplicationChecklistItemEntity> loanApplicationChecklistItemEntity = loanApplicationCheckListItemDao.findById(new LoanApplicationChecklistId(loanActivityDto.getLoanApplicationId(),loanActivityDto.getCheckListTask()));
        if (!loanApplicationChecklistItemEntity.isPresent()) {
            throw new IllegalAccessException("Entity not found");
        }
        LoanApplicationChecklistItemEntity loanApplicationChecklistItemSave = loanApplicationChecklistItemEntity.get();
        loanApplicationChecklistItemSave.setNotes(loanActivityDto.getNotes());
        loanApplicationChecklistItemSave.setIsComplete(loanActivityDto.getIsComplete());
        if(Objects.nonNull(loanApplicationCheckListItemDao.save(loanApplicationChecklistItemSave))){
            return "Data save";
        }
        return null;
    }

    public LoanApplicationResponseDto status(Integer loan, String status) throws IllegalAccessException {
        Optional<LoanApplicationEntity> loanApplicationEntity = loanApplicationDao.findById(loan);
        if (!loanApplicationEntity.isPresent()){
            throw new IllegalAccessException("Loan not there");
        }
        loanApplicationEntity.get().setStatus(status);
        LoanApplicationEntity loanApplicationEntitySave = loanApplicationDao.save(loanApplicationEntity.get());
        return mapper.convertToDto(loanApplicationEntitySave);
    }
}
