package com.ofacms.application.serviceimplementation;

import com.ofacms.application.model.Customer;
import com.ofacms.application.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

 class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
     void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testSaveCustomer() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Customer customer = new Customer(1, "Nandha", "Kumaran", "nandha.kumaran@gmail.com", "1234567890",
                "Bye pass road", "palanganatham", "Tamilnadu", "625003", "INDIA", "nandha", "hashedPassword",
                now, now, "user");

        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer savedCustomer = customerService.saveCustomer(customer);

        assertNotNull(savedCustomer);
        assertEquals(customer.getCustomerId(), savedCustomer.getCustomerId());
        assertEquals(customer.getEmail(), savedCustomer.getEmail());
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
     void testGetCustomerById() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Customer customer = new Customer(1, "Nandha", "Kumaran", "nandha.kumaran@gmail.com", "1234567890",
                "Bye pass road", "palanganatham", "Tamilnadu", "625003", "INDIA", "nandha", "hashedPassword",
                now, now, "user");

        when(customerRepository.findById(anyInt())).thenReturn(customer);

        Customer foundCustomer = customerService.getCustomerById(1);

        assertNotNull(foundCustomer);
        assertEquals(customer.getCustomerId(), foundCustomer.getCustomerId());
        assertEquals(customer.getEmail(), foundCustomer.getEmail());
        verify(customerRepository, times(1)).findById(1);
    }

    @Test
     void testGetAllCustomers() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Customer customer1 = new Customer(1, "Nandha", "Kumaran", "nandha.kumaran@gmail.com", "1234567890",
                "Bye pass road", "palanganatham", "Tamilnadu", "625003", "INDIA", "nandha", "hashedPassword",
                now, now, "user");
        Customer customer2 = new Customer(1, "Suriya", "Kumaran", "suriya.kumaran@gmail.com", "1234567890",
                "Bye pass road", "palanganatham", "Tamilnadu", "625003", "INDIA", "suriya", "hashedPassword",
                now, now, "user");
        List<Customer> customers = Arrays.asList(customer1, customer2);

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> allCustomers = customerService.getAllCustomers();

        assertNotNull(allCustomers);
        assertEquals(2, allCustomers.size());
        assertEquals(customer1.getCustomerId(), allCustomers.get(0).getCustomerId());
        assertEquals(customer2.getCustomerId(), allCustomers.get(1).getCustomerId());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
     void testDeleteCustomerById() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Customer customer = new Customer(1, "Nandha", "Kumaran", "nandha.kumaran@gmail.com", "1234567890",
                "Bye pass road", "palanganatham", "Tamilnadu", "625003", "INDIA", "nandha", "hashedPassword",
                now, now, "user");

        when(customerRepository.findById(anyInt())).thenReturn(customer);

        customerService.deleteCustomerById(1);

        verify(customerRepository, times(1)).delete(1);
    }

    @Test
     void testUpdateCustomer_Success() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Customer existingCustomer = new Customer(1, "Nandha", "Kumaran", "nandha.kumaran@gmail.com", "1234567890",
                "Bye pass road", "palanganatham", "Tamilnadu", "625003", "INDIA", "nandha", "hashedPassword",
                now, now, "user");
        Customer updatedCustomer = new Customer(1, "Suriya", "Kumaran", "suriya.kumaran@gmail.com", "1234567890",
                "Bye pass road", "palanganatham", "Tamilnadu", "625003", "INDIA", "suriya", "hashedPassword",
                now, now, "user");

        when(customerRepository.findById(anyInt())).thenReturn(existingCustomer);
        when(customerRepository.update(any(Customer.class))).thenReturn(updatedCustomer);

        Customer resultCustomer = customerService.updateCustomer(1, updatedCustomer);

        assertNotNull(resultCustomer);
        assertEquals(updatedCustomer.getEmail(), resultCustomer.getEmail());
        assertEquals(updatedCustomer.getUsername(), resultCustomer.getUsername());
        verify(customerRepository, times(1)).update(updatedCustomer);
    }

    @Test
     void testUpdateCustomer_Failure() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Customer customer = new Customer(1, "Nandha", "Kumaran", "nandha.kumaran@gmail.com", "1234567890",
                "Bye pass road", "palanganatham", "Tamilnadu", "625003", "INDIA", "nandha", "hashedPassword",
                now, now, "user");

        when(customerRepository.findById(anyInt())).thenReturn(null);

        Customer resultCustomer = customerService.updateCustomer(1, customer);

        assertNull(resultCustomer);
        verify(customerRepository, times(0)).update(customer);
    }
}
