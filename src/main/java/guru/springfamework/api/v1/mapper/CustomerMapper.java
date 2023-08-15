package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Created by robertZ on 2023-08-10.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}
