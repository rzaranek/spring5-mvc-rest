package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by robertZ on 2023-08-26.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDTO {

    public static final String BASE_URL = "/api/v1/vendors/";

    Long id;
    @ApiModelProperty(value = "vendor's name", required = true)
    String name;
    @ApiModelProperty(value = "vendor's url", readOnly = true)
    @JsonProperty("vendor_url")
    String self_link;

    public String getSelf_link() {
        return BASE_URL + id;
    }
}
