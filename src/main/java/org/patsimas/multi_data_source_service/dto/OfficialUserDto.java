package org.patsimas.multi_data_source_service.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OfficialUserDto {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;
}
