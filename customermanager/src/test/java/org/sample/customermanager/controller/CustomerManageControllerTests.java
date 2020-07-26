package org.sample.customermanager.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.sample.customermanager.dto.CustomerManageDTO;
import org.sample.customermanager.service.CustomerManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * 특정고객관리 Controller Tests
 * @author 이승호
 * @version 1.0
 */

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CustomerManageController.class)
@AutoConfigureMybatis
public class CustomerManageControllerTests {

    @MockBean
    CustomerManageService customerManageService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    // 1번 기능
    @Test
    public void maxSumAmountCustomer() throws Exception {

        List<CustomerManageDTO> customerManageDTOList = new ArrayList<>();
        customerManageDTOList.add(CustomerManageDTO.builder().year("2018").brName("관리점명1")
                .acctNo("관리점코드1").sumAmt("100000000").build());
        customerManageDTOList.add(CustomerManageDTO.builder().year("2018").brName("관리점명2")
                .acctNo("관리점코드2").sumAmt("200000000").build());

        given(customerManageService.findMaxSumAmountCustomer()).willReturn(customerManageDTOList);


        mockMvc.perform(get("/MaxSumAmountCustomer"))
                .andExpect(status().isOk()).andDo(print());
    }

    // 2번 기능
    @Test
    public void findNoneTransactionCustomer() throws Exception {

        List<CustomerManageDTO> customerManageDTOList = new ArrayList<>();
        customerManageDTOList.add(CustomerManageDTO.builder().year("2018").name("계좌명1")
                .acctNo("계좌번호1").sumAmt("100000000").build());
        customerManageDTOList.add(CustomerManageDTO.builder().year("2019").name("계좌명2")
                .acctNo("계좌번호2").sumAmt("200000000").build());


        given(customerManageService.findNoneTransactionCustomer()).willReturn(customerManageDTOList);


        mockMvc.perform(get("/NoneTransactionCustomer"))
                .andExpect(status().isOk()).andDo(print());
    }

    // 3번 기능
    @Test
    public void findMaxSumAmountBranch() throws Exception {
        List<CustomerManageDTO> customerManageDTOList = new ArrayList<>();
        customerManageDTOList.add(CustomerManageDTO.builder().year("2018").brName("관리점명1")
                .brCode("관리점코드1").sumAmt("100000000").build());
        customerManageDTOList.add(CustomerManageDTO.builder().year("2018").brName("관리점명2")
                .brCode("관리점코드2").sumAmt("200000000").build());
        customerManageDTOList.add(CustomerManageDTO.builder().year("2019").brName("관리점명1")
                .brCode("관리점코드1").sumAmt("300000000").build());
        customerManageDTOList.add(CustomerManageDTO.builder().year("2019").brName("관리점명2")
                .brCode("관리점코드2").sumAmt("300000000").build());


        given(customerManageService.findMaxSumAmountBranch()).willReturn(customerManageDTOList);


        mockMvc.perform(get("/MaxSumAmountBranch"))
                .andExpect(status().isOk()).andDo(print());
    }


    // 4번 기능
    @Test
    public void findSumAmountBranch() throws Exception {

        CustomerManageDTO customerManageInDTO = CustomerManageDTO.builder().brName("판교점").build();
        CustomerManageDTO customerManageOutDTO = CustomerManageDTO.builder().brName("판교점")
                                                                    .brCode("A").sumAmt("10000000").build();

        given(customerManageService.findSumAmountBranch(customerManageInDTO)).willReturn(customerManageOutDTO);

        mockMvc.perform(get("/SumAmountBranch").param("brName", "판교점")).andExpect(status().isOk());

    }

    // 4번 기능
    @Test
    public void findSumAmountExceptBranch() throws Exception {

        CustomerManageDTO customerManageInDTO = CustomerManageDTO.builder().brName("분당점").build();

        given(customerManageService.findSumAmountBranch(customerManageInDTO)).willReturn(null);

        mockMvc.perform(get("/SumAmountBranch").param("brName", "분당점")).andDo(print());
    }
}
