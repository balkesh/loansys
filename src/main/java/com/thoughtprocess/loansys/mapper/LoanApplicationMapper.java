package com.thoughtprocess.loansys.mapper;

import com.thoughtprocess.loansys.dto.LoanApplicationResponseDto;
import com.thoughtprocess.loansys.dto.enums.StatusEnum;
import com.thoughtprocess.loansys.entity.LoanApplicationEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,injectionStrategy = InjectionStrategy.FIELD,componentModel = "spring")
public interface LoanApplicationMapper {

    List<LoanApplicationResponseDto> toDto(List<LoanApplicationEntity> loanApplicationEntities);

    @Mappings(value = {
            @Mapping(target="loanApplicationId" , source = "loanApplicationId" ),
            @Mapping( target="applicantName" ,source = "applicantName"),
            @Mapping(target = "status" ,source = "status",  qualifiedByName = "transformStatus")

    })
//    @Mapping(target = "status" ,source = "status",  qualifiedByName = "transformStatus")
    LoanApplicationResponseDto convertToDto(LoanApplicationEntity loanApplicationEntity);

    @Named(value = "transformStatus")
    default StatusEnum transformStatus(String status){
        if(status == null){
            return null;
        }
        if(status.equals("APPROVED")){
            return StatusEnum.APPROVED;
        }
        if (status.equals("REJECTED")){
            return StatusEnum.REJECTED;
        }
        if (status.equals("PENDING")){
            return StatusEnum.PENDING;
        }
        return StatusEnum.APPROVED;
    }
}
