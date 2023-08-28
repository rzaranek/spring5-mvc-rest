package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Created by robertZ on 2023-08-26.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface VendorMapper {
    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    @Mapping(target = "self_link", ignore = true)
    VendorDTO vendorToVendorDTO(Vendor vendor);

    Vendor vendorDtoToVendor(VendorDTO vendorDTO);
}
