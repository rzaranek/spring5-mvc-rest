package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.api.v1.model.VendorListDTO;
import guru.springfamework.services.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by robertZ on 2023-08-26.
 */
@RestController
@RequestMapping(VendorDTO.BASE_URL)
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO getAllVendors() {

        return new VendorListDTO(vendorService.getVendors());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO createNewVendor(@RequestBody VendorDTO vendorDTO) {

        return vendorService.createNewVendor(vendorDTO);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendorById(@PathVariable Long id) {

        return vendorService.getVendorById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO saveVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO) {

        return vendorService.updateVendor(id, vendorDTO);
    }

}
