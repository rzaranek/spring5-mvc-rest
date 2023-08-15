package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by robertZ on 2023-08-10.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {

        return customerMapper.customerToCustomerDTO(customerRepository.findById(id).get());

    }

    private CustomerDTO saveAndReturnDTO(Customer customer) {

        CustomerDTO customerDTO =
                customerMapper.customerToCustomerDTO(customerRepository.save(customer));

        customerDTO.setCustomer_url("/api/v1/customer/" + customer.getId());

        return customerDTO;
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {

        return saveAndReturnDTO(customerMapper.customerDtoToCustomer(customerDTO));

    }

    @Override
    public CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO) {

        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        customer.setId(id);

        return saveAndReturnDTO(customer);
    }
}
