import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spitter.Spitter;
import spitter.data.SpitterRepository;
import spitter.web.HomeController;
import spitter.web.SpitterController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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

    @Test
    public void shouldShowRecentSpitters() throws Exception {

        List<Spitter> expectedSpitters = createSpitterList(20);
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        when(mockRepository.findSpitters(Long.MAX_VALUE, 20))
                .thenReturn(expectedSpitters);

        SpitterController controller = new SpitterController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spitters.jsp"))
                .build();

        mockMvc.perform(get("/spitters"))
                .andExpect(view().name("spitters"))
                .andExpect(model().attributeExists("spitterList"))
                .andExpect(model().attribute("spitterList", hasItems(expectedSpitters.toArray())));
    }

    @Test
    public void shouldShowPagedSpitters() throws Exception {
        List<Spitter> expectedPageSpitters = createSpitterList(50);
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        when(mockRepository.findSpitters(2300, 50))
                .thenReturn(expectedPageSpitters);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spitters.jsp"))
                .build();
        mockMvc.perform(get("/spitters?max=2300&count=50"))
                .andExpect(view().name("spitters"))
                .andExpect(model().attributeExists("spitterList"))
                .andExpect(model().attribute("spitterList", hasItems(expectedPageSpitters.toArray())));
    }

    private List<Spitter> createSpitterList(int count) {
        List<Spitter> spitters = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spitters.add(new Spitter("Spitter " + i, new Date()));
        }
        return spitters;
    }

}
