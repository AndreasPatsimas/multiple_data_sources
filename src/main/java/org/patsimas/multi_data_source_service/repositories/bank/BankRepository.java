package org.patsimas.multi_data_source_service.repositories.bank;

import org.patsimas.multi_data_source_service.domain.bank.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
