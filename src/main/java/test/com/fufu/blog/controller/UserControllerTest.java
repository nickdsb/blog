package test.com.fufu.blog.controller;

import com.fufu.blog.BlogApplication;
import com.fufu.blog.controller.UserController;
import com.fufu.blog.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * UserController Tester.
 *
 * @author <fufu>
 * @version 1.0
 * @since <pre>08/19/2018</pre>
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class UserControllerTest {


    @Autowired
    UserController controller;

    @Autowired
    UserService service;

    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = standaloneSetup(controller).build();
    }


    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(view().name("pages/register"));

    }

    @Test
    public void testRegister() throws Exception {
        String id = "testId" + System.currentTimeMillis();
        mockMvc.perform(post("/register")
                .param("id", id)
                .param("name", "testName")
                .param("password", "gggggg")
                .param("password2", "password")
                .param("verificationCode", "gg"))
                .andExpect(view().name("common/message"));
        assertNotNull(service.getUser(id));
        //重复Register
        try {
            mockMvc.perform(post("/register")
                    .param("id", id)
                    .param("name", "testName")
                    .param("password", "gggggg")
                    .param("password2", "password")
                    .param("verificationCode", "gg"))
                    .andExpect(view().name("common/message"));
        } catch (Exception e) {
            assertNotNull(e);
        }

    }

    @Test
    public void testErrorVerificationCode() throws Exception {
        String testID="xxx"+System.currentTimeMillis();
        mockMvc.perform(post("/register")
                .param("id", testID)
                .param("name", "testName")
                .param("password", "password")
                .param("password2", "password")
                .param("verificationCode", "ggg"))
                .andExpect(view().name("common/message"));
        assertNull(service.getUser(testID));
    }

    @Test
    public void testCheckValidation() throws Exception {
        String id = "testId" + System.currentTimeMillis();
        mockMvc.perform(post("/register")
                .param("id", id)
                .param("name", "testName")
                .param("password", "short")
                .param("password2", "short")
                .param("verificationCode", "gg"))
                .andExpect(view().name("common/message"));
        assertNull(service.getUser(id));
    }


}
 