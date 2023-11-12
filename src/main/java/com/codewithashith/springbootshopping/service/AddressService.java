package com.codewithashith.springbootshopping.service;

import com.codewithashith.springbootshopping.dto.AddressDto;
import com.codewithashith.springbootshopping.exception.common.ResourceNotFoundException;
import com.codewithashith.springbootshopping.model.Address;
import com.codewithashith.springbootshopping.model.AppUser;
import com.codewithashith.springbootshopping.model.Category;
import com.codewithashith.springbootshopping.repository.AddressRepository;
import com.codewithashith.springbootshopping.repository.CategoryRepository;
import com.codewithashith.springbootshopping.repository.UserRepository;
import com.codewithashith.springbootshopping.request.AddressRequest;
import com.codewithashith.springbootshopping.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressDto addressDto;

    public AddressResponse findAll() {
        List<Address> addressList = addressRepository.findAll();
        return addressDto.mapToAddressResponse(addressList);
    }

    @Transactional
    public AddressResponse create(AddressRequest addressRequest) {
        Address address = addressDto.mapToAddress(addressRequest);
        AppUser appUser = userRepository.findById(addressRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId",
                        addressRequest.getUserId()));
        address.setAppUser(appUser);
        addressRepository.save(address);
        return findAll();
    }

    public AddressResponse update(AddressRequest addressRequest) {
        Address address = addressDto.mapToAddress(addressRequest);
        AppUser appUser = userRepository.findById(addressRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId",
                        addressRequest.getUserId()));
        address.setAppUser(appUser);
        addressRepository.save(address);
        return findAll();
    }

    public AddressResponse deleteById(Long id) {
        addressRepository.deleteById(id);
        return findAll();
    }
}
