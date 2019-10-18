package org.patsimas.multi_data_source_service.domain.bank;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Bank")
public class Bank {

    @Id
    @Column(name = "bankcode")
    private Long bankCode;

    @Column(name = "bankcomp")
    private Long bankComp;

    @Column(name = "bankgname")
    private String bankGrName;

    @Column(name = "banklname")
    private String bankElName;

    @Column(name = "bankctry")
    private Long bankCtry;

    @Column(name = "dateins")
    private String dateins;

    @Column(name = "timeins")
    private String timeins;

    @Column(name = "userins")
    private String userins;

    @Column(name = "dateupd")
    private String dateupd;

    @Column(name = "timeupd")
    private String timeupd;

    @Column(name = "userupd")
    private String userupd;

}
