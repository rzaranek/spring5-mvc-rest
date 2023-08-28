package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    String name;
    @JsonProperty("vendor_url")
    String self_link;

    public String getSelf_link() {
        return BASE_URL + id;
    }
}
