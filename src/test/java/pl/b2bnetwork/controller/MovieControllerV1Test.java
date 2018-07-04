package pl.b2bnetwork.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.b2bnetwork.model.Movie;
import pl.b2bnetwork.service.MovieServiceImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieControllerV1.class)
@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class)
@ActiveProfiles("test")
public class MovieControllerV1Test {

    private final static String MAPPING = "/v1/movies/";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MovieServiceImpl service;

    private List<Movie> expected;

    @Before
    public void setUp() {
        Movie forward = Movie.builder().id(1L).title("forward").year(2018).build();
        Movie backward = Movie.builder().id(2L).title("backward").build();
        expected = Arrays.asList(forward, backward);
    }

    @Test
    @WithAnonymousUser
    public void getAllMoviesReturnUnauthorized() throws Exception {

        mvc.perform(get(MAPPING).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "admin")
    public void getAllMoviesIsOkAndHasSizeTwo() throws Exception {

        given(service.getAllMovies()).willReturn(expected);
        mvc.perform(get(MAPPING).contentType(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    @WithMockUser(username = "admin")
    public void getMovieById() throws Exception {
        given(service.getMovieById(1L)).willReturn(expected.get(0));
        mvc.perform(get(MAPPING + "id=1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin")
    public void getMovieByTitle() throws Exception {
        given(service.getMoviesByTitle("forward")).willReturn(Collections.singletonList(expected.get(0)));
        mvc.perform(get(MAPPING + "t=forward").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin")
    public void getMovieByYear() throws Exception {
        given(service.getMoviesByYear(2018)).willReturn(Collections.singletonList(expected.get(0)));
        mvc.perform(get(MAPPING + "y=2018").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin")
    public void countMovies() throws Exception {
        given(service.countMovies()).willReturn("2");
        mvc.perform(get(MAPPING + "count").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin")
    public void addMovie() {
        //TODO add body
    }

    @Test
    @WithMockUser(username = "admin")
    public void updateMovie() {
        //TODO add body
    }
}