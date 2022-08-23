package com.thoughtprocess.loansys.dao;

import com.thoughtprocess.loansys.entity.LoanApplicationChecklistId;
import com.thoughtprocess.loansys.entity.LoanApplicationChecklistItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationCheckListItemDao extends JpaRepository<LoanApplicationChecklistItemEntity, LoanApplicationChecklistId> {
}
