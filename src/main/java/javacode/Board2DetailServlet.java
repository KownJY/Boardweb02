package javacode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detail")
public class Board2DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int iboard = Integer.parseInt(req.getParameter("iboard"));
        Board2VO param = new Board2VO();
        param.setIboard(iboard);
        Board2VO data = Board2DAO.selBoard2Detail(param);

        req.setAttribute("data",data);

        req.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(req,res);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
