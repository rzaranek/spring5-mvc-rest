package guru.springfamework.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by robertZ on 2023-08-10.
 */
@Data
@AllArgsConstructor
public class CustomerListDTO {
    List<CustomerDTO> customers;

}
