package org.patsimas.multi_data_source_service.convert;

import org.patsimas.multi_data_source_service.domain.officialUser.OfficialUser;
import org.patsimas.multi_data_source_service.dto.OfficialUserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OfficialUserToOfficialUserDtoConverter implements Converter<OfficialUser, OfficialUserDto> {

    @Override
    public OfficialUserDto convert(OfficialUser officialUser) {

        return OfficialUserDto.builder()
                .id(officialUser.getId())
                .email(officialUser.getEmail())
                .firstName(officialUser.getFirstName())
                .lastName(officialUser.getLastName())
                .build();
    }
}
