package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.VendorMapper;
import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by robertZ on 2023-08-26.
 */
@Service
public class VendorServiceImpl implements VendorService {

    private final VendorMapper vendorMapper;
    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
        this.vendorMapper = vendorMapper;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<VendorDTO> getVendors() {
        return vendorRepository.findAll()
                .stream()
                .map(vendorMapper::vendorToVendorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {

        return vendorMapper.vendorToVendorDTO(
                vendorRepository.save(vendorMapper.vendorDtoToVendor(vendorDTO)));
    }

    @Override
    public VendorDTO getVendorById(Long id) {

//      return vendorMapper.vendorToVendorDTO(vendorRepository.findById(id).get());

        return vendorRepository.findById(id)
                .map(vendorMapper::vendorToVendorDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public VendorDTO updateVendor(Long id, VendorDTO vendorDTO) {

        Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDTO);
        vendor.setId(id);

        return vendorMapper.vendorToVendorDTO(vendorRepository.save(vendor));
    }

}
