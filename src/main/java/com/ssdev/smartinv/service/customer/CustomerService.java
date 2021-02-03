package com.ssdev.smartinv.service.customer;

import com.ssdev.smartinv.dao.customer.AddressDao;
import com.ssdev.smartinv.dao.customer.CustomerDao;
import com.ssdev.smartinv.dto.CustomerDTO;
import com.ssdev.smartinv.model.common.Address;
import com.ssdev.smartinv.model.customer.Customer;
import com.ssdev.smartinv.service.common.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerService extends ServiceBase<Customer, CustomerDTO> {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private AddressDao addressDao;

    @Override
    public Customer save(CustomerDTO customerDTO) {
        Customer customer = customerDTO.getId() != null ? get(customerDTO.getId()) : new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        Address address = customerDTO.getId() != null ? customer.getAddress() : new Address();
        address.setCountry(customerDTO.getCountry());
        address.setCity(customerDTO.getCity());
        address.setDetails(customerDTO.getDetails());
        address.setPostCode(customerDTO.getPostCode());
        addressDao.save(address);
        customer.setAddress(address);
        customerDao.save(customer);
        return customer;
    }

    public CustomerDTO prepareDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setCountry(customer.getAddress().getCountry());
        customerDTO.setCity(customer.getAddress().getCity());
        customerDTO.setDetails(customer.getAddress().getDetails());
        customerDTO.setPostCode(customer.getAddress().getPostCode());
        return customerDTO;
    }

    @Override
    public Customer get(Long id) {
        return customerDao.get(id);
    }

    @Override
    public List<Customer> getALL() {
        return customerDao.getAll();
    }

    @Override
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }
}
