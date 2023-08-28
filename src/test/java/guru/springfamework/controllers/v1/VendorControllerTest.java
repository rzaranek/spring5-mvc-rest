package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.controllers.RestResponseEntityExceptionHandler;
import guru.springfamework.services.VendorService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static guru.springfamework.controllers.v1.AbstractRestControllerTest.asJsonString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static guru.springfamework.controllers.v1.AbstractRestControllerTest.asJsonString;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by robertZ on 2023-08-26.
 */
public class VendorControllerTest extends TestCase {

    public static final String NAME = "CompanyName";
    public static final long ID = 10L;
    @Mock
    VendorService vendorService;

    @InjectMocks
    VendorController vendorController;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(vendorController)
                .setControllerAdvice(new RestResponseEntityExceptionHandler())
                .build();
    }

    @Test
    public void testGetAllVendors() throws Exception {
        List<VendorDTO> vendorDTOList = Arrays.asList(new VendorDTO(), new VendorDTO(), new VendorDTO());

        when(vendorService.getVendors()).thenReturn(vendorDTOList);

        mockMvc.perform(get(VendorDTO.BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vendors", hasSize(3)));

    }

    @Test
    public void testCreateNewVendor() throws Exception {
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setId(ID);
        vendorDTO.setName(NAME);

        when(vendorService.createNewVendor(any(VendorDTO.class))).thenReturn(vendorDTO);

        mockMvc.perform(post(VendorDTO.BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new VendorDTO())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", equalTo(NAME)));
    }

    @Test
    public void testGetVendorById() throws Exception {

        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setId(ID);
        vendorDTO.setName(NAME);

        when(vendorService.getVendorById(anyLong())).thenReturn(vendorDTO);

        mockMvc.perform(get(VendorDTO.BASE_URL + "/" + ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(NAME)));
    }

    public void testSaveVendor() throws Exception {

        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setId(ID);
        vendorDTO.setName(NAME);

        when(vendorService.updateVendor(anyLong(), any(VendorDTO.class))).thenReturn(vendorDTO);

        mockMvc.perform(put(VendorDTO.BASE_URL + "/" + ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new VendorDTO())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(NAME)));
    }
}