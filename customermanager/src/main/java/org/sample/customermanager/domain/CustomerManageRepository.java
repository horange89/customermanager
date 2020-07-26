package org.sample.customermanager.domain;

import org.sample.customermanager.dto.CustomerManageDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 특정고객관리 CustomerRepository 도메인
 * @author 이승호
 * @version 1.0
 */

@Repository
public interface CustomerManageRepository {

    // 1. API 기능
     List<CustomerManageDTO> findMaxSumAmountCustomer();

    // 2. API 기능
    List<CustomerManageDTO> findNoneTransactionCustomer();

    // 3. API 기능
    List<CustomerManageDTO> findMaxSumAmountBranch();

    // 4. API 기능
    CustomerManageDTO findSumAmountBranch(CustomerManageDTO customerManageDTO);

}
