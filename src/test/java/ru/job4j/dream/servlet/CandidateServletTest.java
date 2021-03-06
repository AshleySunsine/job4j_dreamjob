package ru.job4j.dream.servlet;

import org.junit.Test;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.DbStore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CandidateServletTest {
    @Test
    public void whenCreateCandidate() throws IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("nameOfCandidate")).thenReturn("name of new candidate");
        when(req.getParameter("cityId")).thenReturn("Moscow");
        when(req.getParameter("description")).thenReturn("d");
        new CandidateServlet().doPost(req, resp);
        Candidate candidate = DbStore.instOf().findByNameCandidate("name of new candidate");
        assertThat(candidate, notNullValue());
    }
}