package com.example.exercise20.Service;

import com.example.exercise20.Api.ApiException;
import com.example.exercise20.DTO.AddressDTO;
import com.example.exercise20.Model.Address;
import com.example.exercise20.Model.Teacher;
import com.example.exercise20.Repository.AddressRepository;
import com.example.exercise20.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> findAllAddress() {
        return addressRepository.findAll();
    }

    public void addAddressToTeacher(AddressDTO addressDTO) {

        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("teacher not found");
        }

        Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO) {
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (address == null) {
            throw new ApiException("address not found");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);
    }

    public void deleteAddress(int id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("teacher not found");
        }
        teacher.setAddress(null);
        teacherRepository.save(teacher);
        addressRepository.delete(teacher.getAddress());
    }





}
