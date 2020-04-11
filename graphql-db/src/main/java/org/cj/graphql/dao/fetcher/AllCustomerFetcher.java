package org.cj.graphql.dao.fetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.cj.graphql.dao.entity.Customer;
import org.cj.graphql.dao.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllCustomerFetcher implements DataFetcher<List<Customer>> {

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public List<Customer> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return customerRepo.findAll();
    }
}
