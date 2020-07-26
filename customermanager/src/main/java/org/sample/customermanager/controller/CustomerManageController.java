package org.sample.customermanager.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.sample.customermanager.domain.BranchException;
import org.sample.customermanager.dto.CustomerManageDTO;
import org.sample.customermanager.service.CustomerManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 특정고객관리 Controller
 * @author 이승호
 * @version 1.0
 */
@RestController
public class CustomerManageController {

    private final CustomerManageService customerManageService;

    @Autowired
    public CustomerManageController(CustomerManageService customerManageService) {
        this.customerManageService = customerManageService;
    }

    @GetMapping("/test")
    public ModelAndView testJsp() {
        ModelAndView mv = new ModelAndView("test");
        return mv;
    }

    // 1번 기능
    @GetMapping(value = "/MaxSumAmountCustomer")
    public void findMaxSumAmountCustomer(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        List<CustomerManageDTO> customerManageDTOList = customerManageService.findMaxSumAmountCustomer();;

        JsonArray jsonArray = new JsonArray();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        for(CustomerManageDTO data : customerManageDTOList) {
            jsonArray.add(gson.toJson(data));
        }

        PrintWriter pw = response.getWriter();
        pw.print(jsonArray);
        pw.flush();
    }

    // 2번 기능
    @GetMapping("/NoneTransactionCustomer")
    public void findNoneTransactionCustomer(HttpServletResponse response) throws IOException  {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        List<CustomerManageDTO> customerManageDTOList = customerManageService.findNoneTransactionCustomer();

        JsonArray jsonArray = new JsonArray();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        for(CustomerManageDTO data : customerManageDTOList) {
            jsonArray.add(gson.toJson(data));
        }

        PrintWriter pw = response.getWriter();
        pw.print(jsonArray);
        pw.flush();
    }

    // 3번 기능
    @GetMapping("/MaxSumAmountBranch")
    public void findMaxSumAmountBranch(HttpServletResponse response) throws IOException  {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/String");

        List<CustomerManageDTO> customerManageDTOList = customerManageService.findMaxSumAmountBranch();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonArray jsonArray = new JsonArray();
        JsonArray rArray = new JsonArray();
        PrintWriter pw = response.getWriter();

        // Year 세팅
        List<String> distinctYear = new ArrayList<>();
        for(int i=0; i<customerManageDTOList.size(); i++) {
            if(!distinctYear.contains(customerManageDTOList.get(i).getYear())) {
                distinctYear.add(customerManageDTOList.get(i).getYear());
            }
        }

        // Year로 DataList 세팅
        for(int i=0; i<distinctYear.size(); i++) {
            JsonObject robj = new JsonObject();
            robj.addProperty("year", distinctYear.get(i));
            for (int j = 0; j < customerManageDTOList.size(); j++) {
                if (robj.get("year").getAsString() == customerManageDTOList.get(j).getYear()) {
                    JsonObject obj = new JsonObject();
                    obj.addProperty("brName", customerManageDTOList.get(j).getBrName());
                    obj.addProperty("brCode", customerManageDTOList.get(j).getBrCode());
                    obj.addProperty("sumAmt", customerManageDTOList.get(j).getSumAmt());
                    jsonArray.add(obj);
                }
            }
            robj.add("dataList", jsonArray);
            rArray.add(robj);
        }

        pw.print(rArray.toString());
        pw.flush();
    }

    // 4번 기능
    @GetMapping("/SumAmountBranch")
    public void findSumAmountBranch(@RequestParam("brName") String brName,
                                    HttpServletResponse response) throws IOException  {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");


        CustomerManageDTO customerManageInDTO = new CustomerManageDTO();
        customerManageInDTO.setBrName(brName);
        CustomerManageDTO customerManageOutDTO = customerManageService.findSumAmountBranch(customerManageInDTO);

        PrintWriter pw = response.getWriter();
        JsonArray jsonArray = new JsonArray();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            if(customerManageInDTO.getBrName().equals("분당점") || customerManageOutDTO == null){
                throw new BranchException("br code not found error");
            }
            else {
                jsonArray.add(gson.toJson(customerManageOutDTO));
                pw.print(jsonArray);
                pw.flush();
            }
        } catch (BranchException e) {
            JsonObject obj = new JsonObject();
            obj.addProperty("code", "404");
            obj.addProperty("메세지", e.getMessage());
            jsonArray.add(gson.toJson(obj));
            pw.print(jsonArray);
            pw.flush();
        }

    }
}
