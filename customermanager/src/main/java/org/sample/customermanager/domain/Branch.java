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
 * 특정고객관리 Branch 도메인
 * @author 이승호
 * @version 1.0
 */


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="BRANCH")
public class Branch {

    @Id
    @GeneratedValue
    private Long id;

    private String brCode;

    private String brName;
}
