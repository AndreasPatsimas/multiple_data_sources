package org.patsimas.multi_data_source_service.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BankDto {

    private Long bankCode;

    private String bankName;
}
