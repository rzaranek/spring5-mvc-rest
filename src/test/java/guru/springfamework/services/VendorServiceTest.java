package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.VendorMapper;
import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.VendorRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.print.attribute.standard.MediaSize;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Created by robertZ on 2023-08-26.
 */
public class VendorServiceTest extends TestCase {

    public static final long ID = 22L;
    public static final String NAME = "CompName";
    VendorService vendorService;

    @Mock
    VendorRepository vendorRepository;

    @Before
    public void setUp()  {

        MockitoAnnotations.initMocks(this);

        vendorService = new VendorServiceImpl(VendorMapper.INSTANCE, vendorRepository);
    }

    @Test
    public void testGetVendors() {

        //given
        List<Vendor> vendors = Arrays.asList(new Vendor(), new Vendor());

        when(vendorRepository.findAll()).thenReturn(vendors);

        //when
        List<VendorDTO> vendorDTOList = vendorService.getVendors();

        //then
        assertEquals(2, vendorDTOList.size());
    }

    @Test
    public void testCreateNewVendor() {

        //given
        Vendor vendor = new Vendor();
        vendor.setName(NAME);

        when(vendorRepository.save(any(Vendor.class))).thenReturn(vendor);

        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);

        //when
        VendorDTO vendorDTOsaved = vendorService.createNewVendor(vendorDTO);

        //then
        assertEquals(NAME, vendorDTOsaved.getName());
    }

    @Test
    public void testGetVendorById() {

        //given
        Vendor vendor = new Vendor();
        vendor.setId(ID);
        vendor.setName(NAME);

        given(vendorRepository.findById(anyLong())).willReturn(Optional.of(vendor));

        //when
        VendorDTO vendorDTO = vendorService.getVendorById(ID);

        //then
        then(vendorRepository).should(times(1)).findById(anyLong());

        assertThat(vendorDTO.getName(), is(equalTo(NAME)));
    }

    @Test
    public void testUpdateVendor() {

        //given
        Vendor vendor = new Vendor();
        vendor.setName(NAME);

        when(vendorRepository.save(any(Vendor.class))).thenReturn(vendor);

        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);

        //when
        VendorDTO vendorDTOsaved = vendorService.updateVendor(ID, vendorDTO);

        //the
        assertEquals(NAME, vendorDTOsaved.getName());
    }
}