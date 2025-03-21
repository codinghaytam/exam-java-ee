package org.example.demo8;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.google.gson.Gson;
import org.example.demo8.Dao.DocumentDao;
import org.example.demo8.DaoImp.DocDaoImp;

public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Gson conv = new Gson();
        DocumentDao DocDao = new DocDaoImp();
        List<String> jsonDocs = DocDao.getAllDocuments().stream().map(document -> conv.toJson(document)).collect(Collectors.toList());
        response.getWriter().println(jsonDocs);
    }

    public void destroy() {
        super.destroy();
    }
}