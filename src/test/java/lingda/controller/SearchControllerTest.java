package lingda.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by lingda on 16/07/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SearchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnSearchResultForShow() throws Exception {
        this.mockMvc.perform(post("/search/show").accept(MediaType.APPLICATION_JSON).content("{\"term\":\"hero\"}")
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hero")));
    }

    @Test
    public void shouldReturnSearchResultUsingChineseForShow() throws Exception {
        this.mockMvc.perform(post("/search/show").accept(MediaType.APPLICATION_JSON).content("{\"term\":\"英雄\"}")
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("英雄")));
    }

    @Test
    public void shouldReturnSearchResultUsingPinyinForShow() throws Exception {
        this.mockMvc.perform(post("/search/show").accept(MediaType.APPLICATION_JSON).content("{\"term\":\"yingxiong\"}")
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("英雄")));
    }

    @Test
    public void shouldReturnSearchResultForMovie() throws Exception {
        this.mockMvc.perform(post("/search/movie").accept(MediaType.APPLICATION_JSON).content("{\"term\":\"mummy\"}")
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("木乃伊")));
    }
}
