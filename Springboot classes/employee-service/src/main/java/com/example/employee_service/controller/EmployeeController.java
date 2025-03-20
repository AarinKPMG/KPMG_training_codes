package com.example.employee_service.controller;

import com.example.employee_service.entity.Employee;
import com.example.employee_service.feignClient.AddressClient;
import com.example.employee_service.repository.EmployeeRepository;
import com.example.employee_service.response.AddressResponse;
import com.example.employee_service.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository ;

    @Autowired
    private AddressClient addressClient ;

    @Autowired
    private ModelMapper modelMapper ;

    @GetMapping("/employee/{id}")
    private EmployeeResponse getEmployeeDetails(
            @PathVariable("id") int id
    ){
        Optional<Employee> employee = employeeRepository.findById(id);

        ResponseEntity<AddressResponse> addressResponse =
                addressClient.getAddressByEmployeeId(id);

        EmployeeResponse employeeResponse = modelMapper.map(
                employee , EmployeeResponse.class
        );

        employeeResponse.setAddressResponse( addressResponse.getBody() );

        return employeeResponse ;
    }

}
