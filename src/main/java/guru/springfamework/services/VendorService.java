package guru.springfamework.services;

import guru.springfamework.api.v1.model.VendorDTO;

import java.util.List;

/**
 * Created by robertZ on 2023-08-26.
 */
public interface VendorService {

    List<VendorDTO> getVendors();

    VendorDTO createNewVendor(VendorDTO vendorDTO);

    VendorDTO getVendorById(Long id);

    VendorDTO updateVendor(Long id, VendorDTO vendorDTO);


}
