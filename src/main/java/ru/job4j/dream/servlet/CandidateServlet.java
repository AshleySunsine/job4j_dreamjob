package ru.job4j.dream.servlet;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CandidateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println(req.getParameter("cityId"));
        City city = DbStore.instOf().findCityByName(req.getParameter("cityId"));
        System.out.println(city.getName() + " ++++++");
        DbStore.instOf().saveCandidate(
                new Candidate(
                        Integer.valueOf(req.getParameter("id")),
                        req.getParameter("nameOfCandidate"),
                        city.getId())
                );
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ccc");
        req.setAttribute("candidates", DbStore.instOf().findAllCandidates());
        req.setAttribute("cities", DbStore.instOf().findAllCity());
        req.getRequestDispatcher("candidates.jsp").forward(req, resp);
    }
}
