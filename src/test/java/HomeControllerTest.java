import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spitter.web.HomeController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        //搭建ModkMvc
        MockMvc mockMvc = standaloneSetup(controller).build();
        //对 '/' 执行GET请求
        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));//预期得到home视图
    }

}
