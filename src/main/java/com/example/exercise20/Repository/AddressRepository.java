package com.example.exercise20.Repository;

import com.example.exercise20.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findAddressById(int id);
}
