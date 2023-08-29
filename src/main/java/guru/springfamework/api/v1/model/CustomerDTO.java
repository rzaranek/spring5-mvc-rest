package guru.springfamework.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by robertZ on 2023-08-10.
 */
@Data
public class CustomerDTO {
    private Long id;
    @ApiModelProperty(value = "This is the first name", required = true)
    private String firstname;
    private String lastname;
    private String customer_url;
}
