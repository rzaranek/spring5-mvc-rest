package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by robertZ on 2023-08-10.
 */
public class CustomerMapperTest extends TestCase {

    public static final long ID = 987L;
    public static final String FIRSTNAME = "John";
    public static final String LASTNAME = "Apple";
    public static final String CUSTOMER_URL = "www.apple_john.com";

    CustomerMapper mapper = CustomerMapper.INSTANCE;

    @Test
    public void testCustomerToCustomerDTO() {

        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstname(FIRSTNAME);
        customer.setLastname(LASTNAME);
        customer.setCustomer_url(CUSTOMER_URL);

        //when
        CustomerDTO customerDTO = mapper.customerToCustomerDTO(customer);

        //then
        assertEquals(Long.valueOf(ID), customerDTO.getId());
        assertEquals(FIRSTNAME, customerDTO.getFirstname());
        assertEquals(LASTNAME, customerDTO.getLastname());
        assertEquals(CUSTOMER_URL, customerDTO.getCustomer_url());

    }

    public void testCustomerDtoToCustomer() {
        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(ID);
        customerDTO.setFirstname(FIRSTNAME);
        customerDTO.setLastname(LASTNAME);
        customerDTO.setCustomer_url(CUSTOMER_URL);

        //when
        Customer customer = mapper.customerDtoToCustomer(customerDTO);

        //then
        assertEquals(Long.valueOf(ID), customer.getId());
        assertEquals(FIRSTNAME, customer.getFirstname());
        assertEquals(LASTNAME, customer.getLastname());
        assertEquals(CUSTOMER_URL, customer.getCustomer_url());

    }
}