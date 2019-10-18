package org.patsimas.multi_data_source_service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = {"spring.application.name=MultiDataSourceControllerTest",
        "spring.jmx.default-domain=MultiDataSourceControllerTest"})
public class MultiDataSourceControllerTest extends BasicWiremockTest {

    private static final Integer BANK_UNIT = 131;

    private static final Integer USER_UNIT = 27;

    private static final Integer OFFICIAL_USER_UNIT = 30;

    @Test
    public void findAllMultiDataSourceFromBank() throws Exception {
        this.mockMvc.perform(get(CONTEXT_PATH + "/data/" + BANK_UNIT).contextPath(CONTEXT_PATH))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        System.out.println(this.mockMvc.perform(get(CONTEXT_PATH + "/data/" + BANK_UNIT).contextPath(CONTEXT_PATH))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8")).andReturn().getResponse().getContentAsString());
    }

    @Test
    public void findAllMultiDataSourceFromUser() throws Exception {
        this.mockMvc.perform(get(CONTEXT_PATH + "/data/" + USER_UNIT).contextPath(CONTEXT_PATH))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        System.out.println(this.mockMvc.perform(get(CONTEXT_PATH + "/data/" + USER_UNIT).contextPath(CONTEXT_PATH))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8")).andReturn().getResponse().getContentAsString());
    }

    @Test
    public void findAllMultiDataSourceFromOfficialUser() throws Exception {
        this.mockMvc.perform(get(CONTEXT_PATH + "/data/" + OFFICIAL_USER_UNIT).contextPath(CONTEXT_PATH))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        System.out.println(this.mockMvc.perform(get(CONTEXT_PATH + "/data/" + OFFICIAL_USER_UNIT).contextPath(CONTEXT_PATH))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8")).andReturn().getResponse().getContentAsString());
    }
}
