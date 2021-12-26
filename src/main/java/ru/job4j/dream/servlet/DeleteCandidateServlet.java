package ru.job4j.dream.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.job4j.dream.store.Store;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.http.HttpHeaders;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class DeleteCandidateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File fileToDelete = null;
        String nameForDelete = req.getParameter("id");
        System.out.println("****** -DeleteCandidate " + nameForDelete);
        for (File file: new File(ReadConfigProp.getInstance().value("pathImage")).listFiles()) {
            System.out.println(nameForDelete + " -- name for delete");
            if (nameForDelete.equals(file.getName())) {
                fileToDelete = file.getAbsoluteFile();
                System.out.println(file.getName());
                Store.instOf().deleteCandidate(Integer.parseInt(nameForDelete));
                Files.delete(fileToDelete.toPath());
                System.out.println("DeleteCandidateServlet  IF");
            }
            break;
        }

        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
