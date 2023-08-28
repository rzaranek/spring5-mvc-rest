package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by robertZ on 2023-08-26.
 */
public class VendorMapperTest extends TestCase {

    public static final long ID = 10L;
    public static final String NAME = "Apple Corp";

    VendorMapper mapper = VendorMapper.INSTANCE;

    @Test
    public void testVendorToVendorDTO() {

        //given
        Vendor vendor = new Vendor();
        vendor.setId(ID);
        vendor.setName(NAME);

        //when
        VendorDTO vendorDTO = mapper.vendorToVendorDTO(vendor);

        //then
        assertEquals(Long.valueOf(ID), vendorDTO.getId());
        assertEquals(NAME, vendorDTO.getName());
        assertEquals(VendorDTO.BASE_URL + ID, vendorDTO.getSelf_link());
    }

    @Test
    public void testVendorDtoToVendor() {

        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setId(ID);
        vendorDTO.setName(NAME);

        //when
        Vendor vendor = mapper.vendorDtoToVendor(vendorDTO);

        //then
        assertEquals(Long.valueOf(ID), vendor.getId());
        assertEquals(NAME, vendor.getName());

    }
}