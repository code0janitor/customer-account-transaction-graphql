package org.cj.graphql.dao.prep;

import org.cj.graphql.dao.entity.Account;
import org.cj.graphql.dao.entity.Customer;
import org.cj.graphql.dao.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class DataLoader {

    @Autowired
    CustomerRepo customerRepo;

    @PostConstruct
    @Transactional
    private void createData() {

        /* TODO:
           1. Convert to Stream
           2. Use persistent data store
        */
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> Data Load <<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Customer c1 = new Customer(
                "Yanki", "Chatkula", "EN", "Add-On", "1234", LocalDate.now(), "test@testmenot.in");
        c1.addAccount(new Account("Yanki C", "4321", "02/20", "02/24"));
        c1.addAccount(new Account("Yanki Chat", "3214", "01/19", "02/23"));
        Customer c2 = new Customer(
                "Lola", "Ctam", "EN", "Add-On", "9876", LocalDate.now(), "test@testmenot.in");
        c2.addAccount(new Account("Lola C", "0987", "02/20", "02/24"));
        c2.addAccount(new Account("Lola Ctam", "7890", "01/20", "02/28"));

        customerRepo.save(c1);
        customerRepo.save(c2);
        customerRepo.flush();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> Data Read <<<<<<<<<<<<<<<<<<<<<<");
        /*Customer c3 =   customerRepo.getOne(1);
        System.out.println(c3);*/

        customerRepo.findAll().forEach(
                customer -> System.out.println(customer)
        );
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
