package javacode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/write")
public class Board2WriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/write.jsp");
        rd.forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Board2VO vo = new Board2VO();

        vo.setTitle(req.getParameter("title"));
        vo.setCtnt(req.getParameter("ctnt"));
        vo.setWriter(req.getParameter("writer"));

        int result = Board2DAO.insBoard2(vo);
        switch (result)
        {
            case 1 : res.sendRedirect("/list");
            break;
            default: res.sendRedirect("/write");
            break;
        }

    }
}
