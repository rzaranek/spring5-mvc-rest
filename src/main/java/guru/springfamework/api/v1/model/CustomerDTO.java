package guru.springfamework.api.v1.model;

import lombok.Data;

/**
 * Created by robertZ on 2023-08-10.
 */
@Data
public class CustomerDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String customer_url;
}
