package org.cj.graphql.resource;


import graphql.ExecutionResult;
import org.cj.graphql.conf.GraphQLConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerResource {

    @Autowired
    GraphQLConfig config;

    @PostMapping
    public ResponseEntity<Object> getAllCustomers(@RequestBody String query)
    {
        ExecutionResult executionResult = config.getGraphQL().execute(query);
        return new ResponseEntity<>(executionResult, HttpStatus.OK);
    }



}
