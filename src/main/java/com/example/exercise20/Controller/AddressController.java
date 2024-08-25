package com.example.exercise20.Controller;

import com.example.exercise20.DTO.AddressDTO;
import com.example.exercise20.Model.Address;
import com.example.exercise20.Service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor

public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAllAddress(){
        return ResponseEntity.status(200).body(addressService.findAllAddress());
    }

    @PostMapping("/post")
    public ResponseEntity addAddressToTeacher(@RequestBody AddressDTO addressDTO){
        addressService.addAddressToTeacher(addressDTO);
        return ResponseEntity.status(200).body("address added to teacher successfully");
    }

    @PutMapping("/update")
    public ResponseEntity updateAddressToTeacher( @RequestBody AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body("address updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable int id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("address deleted successfully");
    }



}
