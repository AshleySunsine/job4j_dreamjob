package ru.job4j.dream.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class IndexServlet extends HttpServlet {

    private static final Gson GSON = new GsonBuilder().create();

    private class JsonClass {
        List<Candidate> candidatesList;
        List<Post> postsList;
        List<City> cityList;

        public JsonClass(List<Candidate> candidatesList, List<Post> postsList, List<City> cities) {
            this.candidatesList = candidatesList;
            this.postsList = postsList;
            this.cityList = cities;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        OutputStream output = resp.getOutputStream();

        List<Candidate> candidateList = DbStore.instOf().findCandidateByDay();
        List<Post> postList = DbStore.instOf().findPostByDay();
        List<City> cityList = DbStore.instOf().findAllCity();
        JsonClass jsonList = new JsonClass(candidateList, postList, cityList);

        String jsonLi = GSON.toJson(jsonList);
        System.out.println(jsonLi);
        output.write((jsonLi).getBytes(StandardCharsets.UTF_8));
        System.out.println(output);
        output.flush();
        output.close();
    }
}