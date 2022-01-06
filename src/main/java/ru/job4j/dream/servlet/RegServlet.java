package ru.job4j.dream.servlet;

import ru.job4j.dream.model.User;
import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if ((name != null)
            && (email != null)
            && (password != null)
            && !name.isEmpty()
            && !email.isEmpty()
            && !password.isEmpty()) {
                DbStore.instOf().saveUser(
                        new User(0, name, email, password));
                System.out.println("RegServlet work");
                System.out.println(DbStore.instOf().findUserByEmail(req.getParameter("email")));
                req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Не верный email или пароль");
            req.getRequestDispatcher("reg.jsp").forward(req, resp);
        }
    }
}