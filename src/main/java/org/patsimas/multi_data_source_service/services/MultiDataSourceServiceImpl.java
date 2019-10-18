package org.patsimas.multi_data_source_service.services;

import lombok.extern.slf4j.Slf4j;
import org.patsimas.multi_data_source_service.domain.bank.Bank;
import org.patsimas.multi_data_source_service.domain.officialUser.OfficialUser;
import org.patsimas.multi_data_source_service.domain.user.User;
import org.patsimas.multi_data_source_service.dto.BankDto;
import org.patsimas.multi_data_source_service.dto.OfficialUserDto;
import org.patsimas.multi_data_source_service.dto.UserDto;
import org.patsimas.multi_data_source_service.repositories.bank.BankRepository;
import org.patsimas.multi_data_source_service.repositories.officialUser.OfficialUserRepository;
import org.patsimas.multi_data_source_service.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MultiDataSourceServiceImpl implements MultiDataSourceService {

    @Autowired
    BankRepository bankRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OfficialUserRepository officialUserRepository;

    @Autowired
    private ConversionService conversionService;

    @Override
    public Object getMultiDataSourceByUnit(Integer unit) {

        log.info("Fetch data process begins.");

        switch (unit){
            case 131: {

                List<Bank> bankList = bankRepository.findAll();

                List<BankDto> bankDtoList =  new ArrayList<>(bankList.size());

                bankList.forEach(bank -> {
                    bankDtoList.add(conversionService.convert(bank, BankDto.class));
                });

                log.info("Fetch data process completed with unit :{} .", unit);

                return bankDtoList;
            }

            case 27: {

                List<User> userList = userRepository.findAll();

                List<UserDto> userDtoList =  new ArrayList<>(userList.size());

                userList.forEach(user -> {
                    userDtoList.add(conversionService.convert(user, UserDto.class));
                });

                log.info("Fetch data process completed with unit :{} .", unit);

                return userDtoList;
            }

            case 30: {

                List<OfficialUser> officialUserList = officialUserRepository.findAll();

                List<OfficialUserDto> officialUserDtoList =  new ArrayList<>(officialUserList.size());

                officialUserList.forEach(officialUser -> {
                    officialUserDtoList.add(conversionService.convert(officialUser, OfficialUserDto.class));
                });

                log.info("Fetch data process completed with unit :{} .", unit);

                return officialUserDtoList;
            }

            default:
                return null;
        }
    }
}
