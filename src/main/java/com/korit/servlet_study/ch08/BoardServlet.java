package com.korit.servlet_study.ch08;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Postman에서 post로 요청을 보내면 DoPost가 있어야함
@WebServlet("/ch08/boards") // get으로 보내면 DoGet
public class BoardServlet extends HttpServlet {
    private List<Board> boards;
    public BoardServlet() { boards = new ArrayList<>();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        ObjectMapper om = new ObjectMapper();
        om.writeValue(resp.getWriter(), boards);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
//        String json = "";
//        while (true) {
//            String str = br.readLine();
//            if (str == null) break;
//            json += str;
//        }
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        Board board = new ObjectMapper().readValue(req.getInputStream(), Board.class);
        if (boards.contains(board)) {
            return;
        } else boards.add(board);
        System.out.println(boards);

        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");

        Response response = new Response("게시글 작성 완료");
        String responseJson = new ObjectMapper().writeValueAsString(response);
        resp.getWriter().println(responseJson);



    }

}
