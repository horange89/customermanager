package org.sample.customermanager.service;

import org.sample.customermanager.domain.MyBatisCustomerManageRepository;
import org.sample.customermanager.dto.CustomerManageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 특정고객관리 Service
 * @author 이승호
 * @version 1.0
 *
 */
@Service
public class CustomerManageService {

    MyBatisCustomerManageRepository myBatisCustomerManageRepository;

    @Autowired
    public CustomerManageService(MyBatisCustomerManageRepository myBatisCustomerManageRepository) {
        this.myBatisCustomerManageRepository = myBatisCustomerManageRepository;
    }

    public List<CustomerManageDTO> findMaxSumAmountCustomer() {
        return myBatisCustomerManageRepository.findMaxSumAmountCustomer();
    }

    public List<CustomerManageDTO> findNoneTransactionCustomer() {
        return myBatisCustomerManageRepository.findNoneTransactionCustomer();
    }

    public List<CustomerManageDTO> findMaxSumAmountBranch() {
        return myBatisCustomerManageRepository.findMaxSumAmountBranch();
    }

    public CustomerManageDTO findSumAmountBranch(CustomerManageDTO customerManageDTO) {
        return myBatisCustomerManageRepository.findSumAmountBranch(customerManageDTO);
    }

}
