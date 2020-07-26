package org.sample.customermanager.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 특정고객관리 Account 도메인
 * @author 이승호
 * @version 1.0
 */

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ACCOUNT")
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String acctNo;

    private String name;

    private String branch;
}
