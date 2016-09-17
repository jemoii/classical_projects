package me.voler.classical.ticket.servlet.web;

import me.voler.classical.ticket.servlet.model.CoreService;
import me.voler.classical.ticket.train.Train;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CoreServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String from_station_name = request.getParameter("from_station_name");
        String to_station_name = request.getParameter("to_station_name");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        List<Train> result = CoreService.getBalance(from_station_name, to_station_name, month, day);

        request.setAttribute("balance", result);
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }

}
