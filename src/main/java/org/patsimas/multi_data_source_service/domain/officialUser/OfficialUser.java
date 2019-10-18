package org.patsimas.multi_data_source_service.domain.officialUser;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "PCB_USER1.USERS")
public class OfficialUser {

    @Id
    @Column(name = "USERCODE")
    private Long id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "POSITION")
    private Integer position;

    @NotNull
    @Column(name = "STATUSCODE")
    private Integer statusCode;

    @Column(name = "TELEPHONE")
    private String telephone;

    @NotNull
    @Column(name = "TIMEINSERT")
    private Instant timeInsert;

    @NotNull
    @Column(name = "TIMEUPDATE")
    private Instant timeUpdate;

    @NotNull
    @Column(name = "USERINSERT")
    private String userInsert;

    @NotNull
    @Column(name = "USERUPDATE")
    private String userUpdate;
}
