package org.sample.customermanager;

import lombok.extern.slf4j.Slf4j;
import org.sample.customermanager.domain.Account;
import org.sample.customermanager.domain.Branch;
import org.sample.customermanager.domain.Transaction;
import org.sample.customermanager.domain.AccountRepository;
import org.sample.customermanager.domain.BranchRepository;
import org.sample.customermanager.domain.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * CommandLine 구현을 통하여 애플리케이션 시작시 데이터 적재
 * @author 이승호
 * @version 1.0
 *
 */
@Profile("!test")
@Component
@Slf4j
public class MyCLRunner implements CommandLineRunner {

    @Autowired(required=true)
    AccountRepository accountRepository;

    @Autowired(required=true)
    BranchRepository branchRepository;

    @Autowired(required=true)
    TransactionRepository transactionRepository;

    @Override
    public void run(String... args) throws Exception {
        initAccountData();
        initBranchData();
        initTransactionData();
    }

    public void initAccountData() {
        ClassPathResource resource = new ClassPathResource("데이터_계좌정보.csv");

        try {
            Path path = Paths.get(resource.getURI());
            List<String> content = Files.readAllLines(path);
            List<Account> accountList = new ArrayList<>();

            for(int i=1; i<content.size(); i++) {
                Account account = new Account();
                String values[] = content.get(i).split(",");

                account.setAcctNo(values[0]);
                account.setName(values[1]);
                account.setBranch(values[2]);

                accountList.add(account);
            }

            accountRepository.saveAll(accountList);

        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    public void initBranchData() {
        ClassPathResource resource = new ClassPathResource("데이터_관리점정보.csv");

        try {
            Path path = Paths.get(resource.getURI());
            List<String> content = Files.readAllLines(path);
            List<Branch> branchList = new ArrayList<>();

            for(int i=1; i<content.size(); i++) {
                Branch branch = new Branch();
                String values[] = content.get(i).split(",");

                branch.setBrCode(values[0]);
                branch.setBrName(values[1]);

                branchList.add(branch);
            }

            branchRepository.saveAll(branchList);

        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

    public void initTransactionData() {
        ClassPathResource resource = new ClassPathResource("데이터_거래내역.csv");

        try {
            Path path = Paths.get(resource.getURI());
            List<String> content = Files.readAllLines(path);
            List<Transaction> transactionList = new ArrayList<>();

            for(int i=1; i<content.size(); i++) {
                Transaction transaction = new Transaction();
                String values[] = content.get(i).split(",");

                transaction.setTrDate(LocalDate.parse(values[0], DateTimeFormatter.ofPattern("yyyyMMdd")));
                transaction.setAcctNo(values[1]);
                transaction.setTrNo(values[2]);
                transaction.setPrice(Integer.parseInt(values[3]));
                transaction.setFees(Integer.parseInt(values[4]));
                transaction.setCancle_yn(values[5]);

                transactionList.add(transaction);
            }

            transactionRepository.saveAll(transactionList);

        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }

}
