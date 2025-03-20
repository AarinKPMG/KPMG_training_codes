package com.example.address_service.controller;

import com.example.address_service.entity.Address;
import com.example.address_service.repository.AddressRepository;
import com.example.address_service.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository addressRepository ;

    @GetMapping("/address/{employeeId}")
    private ResponseEntity<?> getAddressByEmployeeId(
            @PathVariable("employeeId") int employeeId
    ){

        Optional<Address> addressResponse = addressRepository.findAddressByEmployeeId(employeeId);
        return new ResponseEntity(addressResponse , HttpStatus.OK);

    }

}
