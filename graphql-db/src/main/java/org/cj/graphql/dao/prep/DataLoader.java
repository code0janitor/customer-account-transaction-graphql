package org.cj.graphql.dao.prep;

import org.cj.graphql.dao.entity.Account;
import org.cj.graphql.dao.entity.Customer;
import org.cj.graphql.dao.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Random;

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


        for(int index=1000; index<1100;index++) {
            int random = new Random().nextInt(index);

            Customer c1 = new Customer(
                    "Yanki" + "-" + random, "Chatkula"+"-" + random, "EN", "Add-On", "1234", LocalDate.now().toString(), "test@testmenot.in");
            c1.addAccount(new Account("Yanki C"+ "-" + random, "4321", "02/20", "02/24"));
            c1.addAccount(new Account("Yanki Chat"+ "-" + random, "3214", "01/19", "02/23"));

            customerRepo.save(c1);
            customerRepo.flush();
            System.out.println(" Record created >>>>" + "Yanki" + "-" + random);

        }
        /*customerRepo.findAll().forEach(
                customer -> System.out.println(customer)
        );*/
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
