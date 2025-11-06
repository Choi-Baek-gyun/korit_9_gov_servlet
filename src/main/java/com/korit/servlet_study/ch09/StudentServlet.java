package com.korit.servlet_study.ch09;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@WebServlet("/study/students")
public class StudentServlet extends HttpServlet {
    private StudentRepository studentRepository;
    ObjectMapper om = new ObjectMapper();

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = new StudentRepository();
        config.getServletContext().setAttribute("studentRepository", studentRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        String searchNameValue = req.getParameter("searchName");

        om.writeValue(resp.getWriter(), studentRepository.findAllBySearchNameValue(searchNameValue));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");
        ObjectMapper om = new ObjectMapper();
//        Response response = new Response("학생 정보 입력 완료");
//        String strResp = new ObjectMapper().writeValueAsString(response);
//        resp.getWriter().println(strResp);

        Student student = om.readValue(req.getInputStream(), Student.class);
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.insert(student);

        om.writeValue(resp.getWriter(), Map.of("message", "학생 추가 완료"));
    }
}
