package com.thoughtprocess.loansys.dao;

import com.thoughtprocess.loansys.entity.LoanApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LoanApplicationDao extends JpaRepository<LoanApplicationEntity,Integer> {

    List<LoanApplicationEntity> findByApplicantNameAndStatus(final String applicantName,final String status);
}
