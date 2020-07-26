package org.sample.customermanager.dto;

import lombok.*;

/**
 * 특정고객관리  DTO
 * @author 이승호
 * @version 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerManageDTO {

    private String year;

    private String name;

    private String acctNo;

    private String branch;

    private String brCode;

    private String brName;

    private String trDate;

    private String trNo;

    private String price;

    private String fees;

    private String cancle_yn;

    private String sumAmt;

    @Override
    public String toString() {
        return "CustomerManageDTO{" +
                "year='" + year + '\'' +
                ", name='" + name + '\'' +
                ", acctNo='" + acctNo + '\'' +
                ", branch='" + branch + '\'' +
                ", brCode='" + brCode + '\'' +
                ", brName='" + brName + '\'' +
                ", trDate='" + trDate + '\'' +
                ", trNo='" + trNo + '\'' +
                ", price='" + price + '\'' +
                ", fees='" + fees + '\'' +
                ", cancle_yn='" + cancle_yn + '\'' +
                ", sumAmt='" + sumAmt + '\'' +
                '}';
    }
}
