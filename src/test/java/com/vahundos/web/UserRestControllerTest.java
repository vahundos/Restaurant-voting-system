package com.vahundos.web;

import com.vahundos.TestUtil;
import com.vahundos.model.User;
import com.vahundos.service.user.UserService;
import com.vahundos.web.json.JsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.vahundos.UserTestData.getForCreation;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = UserRestController.REST_URL + "/";

    @Autowired
    private UserService service;

    @Test
    public void testCreate() throws Exception {
        User expected = getForCreation();
        mockMvc.perform(post(REST_URL)
                .contentType(APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected)))
                .andExpect(status().isOk())
                .andDo(print());

        User actual = service.getByEmail(expected.getEmail());
        actual.setId(expected.getId());
        TestUtil.assertMatch(actual, expected);
    }
}
