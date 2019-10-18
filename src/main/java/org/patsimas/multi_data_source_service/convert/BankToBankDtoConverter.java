package org.patsimas.multi_data_source_service.convert;

import org.patsimas.multi_data_source_service.domain.bank.Bank;
import org.patsimas.multi_data_source_service.dto.BankDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BankToBankDtoConverter implements Converter<Bank, BankDto> {

    @Override
    public BankDto convert(Bank bank) {
        return BankDto.builder()
                .bankCode(bank.getBankCode())
                .bankName(bank.getBankGrName())
                .build();
    }
}
