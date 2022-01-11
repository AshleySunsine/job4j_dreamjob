package ru.job4j.dream.servlet;

import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditCandidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cities", DbStore.instOf().findAllCity());
        req.getRequestDispatcher("/candidate/edit.jsp").forward(req, resp);
    }
}
