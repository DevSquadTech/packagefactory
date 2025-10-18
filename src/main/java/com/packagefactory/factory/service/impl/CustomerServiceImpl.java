package com.packagefactory.factory.service.impl;

import com.packagefactory.factory.core.constants.SuccessStatus;
import com.packagefactory.factory.core.response.ApiResponse;
import com.packagefactory.factory.core.utils.ResponseUtil;
import com.packagefactory.factory.dto.CustomerDto;
import com.packagefactory.factory.entity.Customer;
import com.packagefactory.factory.exception.NotFoundException;
import com.packagefactory.factory.repository.CustomerRepository;
import com.packagefactory.factory.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ApiResponse<CustomerDto> create(CustomerDto customerDto) {
        Customer customer = toEntity(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDto savedDto = toDto(savedCustomer);
        return
            ResponseUtil.success(savedDto, SuccessStatus.ENTRY_CREATED,"CustomerCreared");
    }

    @Override
    public ApiResponse<CustomerDto> update(Long id, CustomerDto customerDto) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found with id: " + id));
        updateEntityFromDto(existingCustomer, customerDto);
        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return ResponseUtil.success(toDto(updatedCustomer), SuccessStatus.ENTRY_UPDATED, "Customer updated");
    }

    @Override
    public ApiResponse<CustomerDto> delete(Long id) {
        Customer existing = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found with id: " + id));
        customerRepository.delete(existing);
        return ResponseUtil.success(null, SuccessStatus.ENTRY_DELETED, "Customer deleted");    }

    @Override
    public ApiResponse<CustomerDto> getById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found with id: " + id));
        CustomerDto customerDto = toDto( customer);
        return
            ResponseUtil.success(customerDto, SuccessStatus.ENTRY_FOUND, "Customer found");

    }

    @Override
    public ApiResponse<List<CustomerDto>> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = customers.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseUtil.success(customerDtos, SuccessStatus.ENTRY_FOUND, "Customers fetched");

    }

    private Customer toEntity(CustomerDto dto){
        Customer c = new Customer();
        c.setName(dto.getName());
        c.setPhone(dto.getPhone());
        c.setAddress(dto.getAddress());
        c.setEmail(dto.getEmail());
        c.setNotes(dto.getNotes());
        c.setBalance(dto.getBalance() != null ? dto.getBalance() : 0.0);
        return c;
    }
    private CustomerDto toDto(Customer customer) {
        CustomerDto dto = new CustomerDto();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setPhone(customer.getPhone());
        dto.setAddress(customer.getAddress());
        dto.setEmail(customer.getEmail());
        dto.setNotes(customer.getNotes());
        dto.setBalance(customer.getBalance());
        return dto;
    }

    private void updateEntityFromDto(Customer c, CustomerDto dto){
        if(dto.getName() != null) c.setName(dto.getName());
        if(dto.getPhone() != null) c.setPhone(dto.getPhone());
        if(dto.getAddress() != null) c.setAddress(dto.getAddress());
        if(dto.getEmail() != null) c.setEmail(dto.getEmail());
        if(dto.getNotes() != null) c.setNotes(dto.getNotes());
        if(dto.getBalance() != null) c.setBalance(dto.getBalance());
    }
}
