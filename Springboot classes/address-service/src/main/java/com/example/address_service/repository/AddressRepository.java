package com.example.address_service.repository;

import com.example.address_service.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Integer> {

    @Query(
        nativeQuery=true,
        value = "select ea.id , ea.city , ea.state from " +
                "hplus4.address ea join hplus4.employee e "+
                "on ea.id = e.id where e.id = :employeeId"
    )
    Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employee);

}
