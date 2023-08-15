package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

/**
 * Created by robertZ on 2023-08-10.
 */
public class CustomerServiceTest extends TestCase {

    public static final long ID = 632L;
    public static final String FIRSTNAME = "Baby";
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    public void testGetAllCustomers() {

        //given
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        //when
        List<CustomerDTO> customerDTOs = customerService.getAllCustomers();

        //then
        assertEquals(3, customerDTOs.size());
    }

    public void testGetCustomerById() {

        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstname(FIRSTNAME);

        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));

        //when
        CustomerDTO customerDTO = customerService.getCustomerById(ID);

        //then
        assertEquals(ID, customerDTO.getId().longValue());
        assertEquals(FIRSTNAME, customerDTO.getFirstname());
    }

    public void testCreateNewCustomer() {

        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(ID);
        customerDTO.setFirstname(FIRSTNAME);

        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstname(FIRSTNAME);

        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        //when
        CustomerDTO savedCustomerDTO = customerService.createNewCustomer(customerDTO);

        //then
        assertEquals(customerDTO.getId(), savedCustomerDTO.getId());
    }

    public void testSaveCustomerByDTO() {

        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(ID);
        customerDTO.setFirstname(FIRSTNAME);

        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstname(FIRSTNAME);

        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        //when
        CustomerDTO savedCustomerDTO = customerService.saveCustomerByDTO(ID, customerDTO);

        //then
        assertEquals(Long.valueOf(ID), savedCustomerDTO.getId());
        assertEquals(FIRSTNAME, savedCustomerDTO.getFirstname());

    }
}