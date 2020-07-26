package org.sample.customermanager.service;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sample.customermanager.domain.MyBatisCustomerManageRepository;
import org.sample.customermanager.dto.CustomerManageDTO;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * 특정고객관리 Service Test
 * @author 이승호
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerManageServiceTests {

    private CustomerManageService customerManageService;

    @Mock
    MyBatisCustomerManageRepository mockRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        customerManageService = new CustomerManageService(mockRepository);
    }

    @Test
    public void findMaxSumAmountCustomer() {
        //given
        List<CustomerManageDTO> customerManageDTOList = new ArrayList<>();
        customerManageDTOList.add(CustomerManageDTO.builder().year("2018").name("계좌명1")
                .acctNo("계좌번호1").build());
        customerManageDTOList.add(CustomerManageDTO.builder().year("2019").name("계좌명2")
                .acctNo("계좌번호2").build());

        given(mockRepository.findMaxSumAmountCustomer()).willReturn(customerManageDTOList);

        //when
        List<CustomerManageDTO> resultList = mockRepository.findMaxSumAmountCustomer();

        //then
        verify(mockRepository, times(1)).findMaxSumAmountCustomer();
        assertThat(resultList.get(0).getYear(), is("2018"));
        assertThat(resultList.get(0).getName(), is("계좌명1"));
        assertThat(resultList.get(0).getAcctNo(), is("계좌번호1"));

        assertThat(resultList.get(1).getYear(), is("2019"));
        assertThat(resultList.get(1).getName(), is("계좌명2"));
        assertThat(resultList.get(1).getAcctNo(), is("계좌번호2"));
    }

    @Test
    public void findNoneTransactionCustomer() {
        //given
        List<CustomerManageDTO> customerManageDTOList = new ArrayList<>();
        customerManageDTOList.add(CustomerManageDTO.builder().year("2018").name("계좌명1")
                .acctNo("계좌번호1").sumAmt("100000000").build());
        customerManageDTOList.add(CustomerManageDTO.builder().year("2019").name("계좌명2")
                .acctNo("계좌번호2").sumAmt("200000000").build());

        given(mockRepository.findNoneTransactionCustomer()).willReturn(customerManageDTOList);

        //when
        List<CustomerManageDTO> resultList = mockRepository.findNoneTransactionCustomer();

        //then
        verify(mockRepository, times(1)).findNoneTransactionCustomer();
        assertThat(resultList.get(0).getYear(), is("2018"));
        assertThat(resultList.get(0).getName(), is("계좌명1"));
        assertThat(resultList.get(0).getAcctNo(), is("계좌번호1"));
        assertThat(resultList.get(0).getSumAmt(), is("100000000"));

        assertThat(resultList.get(1).getYear(), is("2019"));
        assertThat(resultList.get(1).getName(), is("계좌명2"));
        assertThat(resultList.get(1).getAcctNo(), is("계좌번호2"));
        assertThat(resultList.get(1).getSumAmt(), is("200000000"));
    }

    @Test
    public void findMaxSumAmountBranch() {
        //given
        List<CustomerManageDTO> customerManageDTOList = new ArrayList<>();
        customerManageDTOList.add(CustomerManageDTO.builder().year("2018").brName("관리점명1")
                .brCode("관리점코드1").sumAmt("100000000").build());
        customerManageDTOList.add(CustomerManageDTO.builder().year("2018").brName("관리점명2")
                .brCode("관리점코드2").sumAmt("200000000").build());
        customerManageDTOList.add(CustomerManageDTO.builder().year("2019").brName("관리점명1")
                .brCode("관리점코드1").sumAmt("300000000").build());
        customerManageDTOList.add(CustomerManageDTO.builder().year("2019").brName("관리점명2")
                .brCode("관리점코드2").sumAmt("300000000").build());

        given(mockRepository.findMaxSumAmountBranch()).willReturn(customerManageDTOList);

        //when
        List<CustomerManageDTO> resultList = mockRepository.findMaxSumAmountBranch();

        //then
        verify(mockRepository, times(1)).findMaxSumAmountBranch();
        assertThat(resultList.get(0).getYear(), is("2018"));
        assertThat(resultList.get(0).getBrName(), is("관리점명1"));
        assertThat(resultList.get(0).getBrCode(), is("관리점코드1"));
        assertThat(resultList.get(0).getSumAmt(), is("100000000"));

        assertThat(resultList.get(1).getYear(), is("2018"));
        assertThat(resultList.get(1).getBrName(), is("관리점명2"));
        assertThat(resultList.get(1).getBrCode(), is("관리점코드2"));
        assertThat(resultList.get(1).getSumAmt(), is("200000000"));

        assertThat(resultList.get(2).getYear(), is("2019"));
        assertThat(resultList.get(2).getBrName(), is("관리점명1"));
        assertThat(resultList.get(2).getBrCode(), is("관리점코드1"));
        assertThat(resultList.get(2).getSumAmt(), is("300000000"));

        assertThat(resultList.get(3).getYear(), is("2019"));
        assertThat(resultList.get(3).getBrName(), is("관리점명2"));
        assertThat(resultList.get(3).getBrCode(), is("관리점코드2"));
        assertThat(resultList.get(3).getSumAmt(), is("300000000"));
    }

    @Test
    public void findSumAmountBranch() {
        //given
        CustomerManageDTO customerManageInDTO = CustomerManageDTO.builder().brName("판교점").build();
        CustomerManageDTO customerManageOutDTO = CustomerManageDTO.builder().brName("판교점")
                                                                    .brCode("A").sumAmt("10000000").build();

        given(mockRepository.findSumAmountBranch(customerManageInDTO)).willReturn(customerManageOutDTO);

        //when
        customerManageOutDTO = mockRepository.findSumAmountBranch(customerManageInDTO);

        //then
        verify(mockRepository, times(1)).findSumAmountBranch(customerManageInDTO);
        assertThat(customerManageOutDTO.getBrName(), is("판교점"));
        assertThat(customerManageOutDTO.getBrCode(), is("A"));
        assertThat(customerManageOutDTO.getSumAmt(), is("10000000"));


    }
}