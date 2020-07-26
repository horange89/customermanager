package org.sample.customermanager.domain;

import org.apache.ibatis.session.SqlSession;
import org.sample.customermanager.dto.CustomerManageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * 특정고객관리 MyBatisManageRepository
 * @author 이승호
 * @version 1.0
 */
@Repository
public class MyBatisCustomerManageRepository implements CustomerManageRepository {

    @Autowired
    private SqlSession sqlSession;

    public List<CustomerManageDTO> findMaxSumAmountCustomer() {
        return sqlSession.selectList("CustomerTransaction.findMaxSumAmountCustomer");
    }

    public List<CustomerManageDTO> findNoneTransactionCustomer() {
        return sqlSession.selectList("CustomerTransaction.findNoneTransactionCustomer");
    }

    public List<CustomerManageDTO> findMaxSumAmountBranch() {
        return sqlSession.selectList("CustomerTransaction.findMaxSumAmountBranch");
    }

    public CustomerManageDTO findSumAmountBranch(CustomerManageDTO customerManageDTO) {
        return sqlSession.selectOne("CustomerTransaction.findSumAmountBranch", customerManageDTO);
    }

}
