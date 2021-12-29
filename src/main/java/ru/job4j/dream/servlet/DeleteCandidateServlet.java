package ru.job4j.dream.servlet;

import ru.job4j.dream.store.MemStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class DeleteCandidateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        File fileToDelete;
        String nameForDelete = req.getParameter("id");
        System.out.println("****** -DeleteCandidate " + nameForDelete);
        for (File file: new File(ReadConfigProp.getInstance().value("pathImage")).listFiles()) {
            System.out.println(nameForDelete + " -- name for delete");
            if (nameForDelete.equals(file.getName())) {
                fileToDelete = file.getAbsoluteFile();
                System.out.println(file.getName());
                MemStore.instOf().deleteCandidate(Integer.parseInt(nameForDelete));
                Files.delete(fileToDelete.toPath());
                System.out.println("DeleteCandidateServlet  IF");
            }
            break;
        }
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
