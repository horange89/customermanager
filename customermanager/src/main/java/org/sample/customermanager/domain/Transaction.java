package org.sample.customermanager.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * 특정고객관리 Transaction 도메인
 * @author 이승호
 * @version 1.0
 */

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate trDate;

    private String acctNo;

    private String trNo;

    private int price;

    private int fees;

    private String cancle_yn;

    public Transaction(LocalDate trDate, String acctNo, String trNo, int price, int fees, String cancle_yn) {
        this.trDate = trDate;
        this.acctNo = acctNo;
        this.trNo = trNo;
        this.price = price;
        this.fees = fees;
        this.cancle_yn = cancle_yn;
    }
}
