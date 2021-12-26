package ru.job4j.dream.servlet;

import ru.job4j.dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File fileToDelete = null;
        String nameForDelete = req.getParameter("id");
        System.out.println("****** - DeleteServlet  nameForDelete " + nameForDelete);
        for (File file: new File(ReadConfigProp.getInstance().value("pathImage")).listFiles()) {
            System.out.println("****** - DeleteServlet file.getName() " + file.getName());
            if (nameForDelete.equals(file.getName())) {
                System.out.println("DeleteServlet  IF");
                fileToDelete = file.getAbsoluteFile();
                Files.delete(fileToDelete.toPath());
            }
            break;
        }
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
