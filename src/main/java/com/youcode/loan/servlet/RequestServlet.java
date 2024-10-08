package com.youcode.loan.servlet;


import com.youcode.loan.enums.Title;
import com.youcode.loan.model.Request;
import com.youcode.loan.service.RequestService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@WebServlet(name = "RequestServlet", value = "/requests")
@AllArgsConstructor
public class RequestServlet extends HttpServlet {

    private final RequestService requestService;

    public void createRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String project = request.getParameter("project");
        String occupation = request.getParameter("occupation");
        Double amount = Double.parseDouble(request.getParameter("amount"));
        Integer period = Integer.parseInt(request.getParameter("period"));
        Double monthlyPayment = Double.parseDouble(request.getParameter("monthlyPayment"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Title  title = Title.valueOf(request.getParameter("title"));
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String idCard = request.getParameter("idCard");
        LocalDate birthdate = LocalDate.parse(request.getParameter("birthdate"));
        LocalDate hiringDate = LocalDate.parse(request.getParameter("hiringDate"));
        Double monthlyIncome = Double.parseDouble(request.getParameter("monthlyIncome"));
        boolean oldLoan = Boolean.parseBoolean(request.getParameter("oldLoan"));

        Request request1 = new Request(UUID.randomUUID(),project, occupation, amount, period, monthlyPayment, email, phone,
                title, name, lastName, idCard, birthdate, hiringDate, monthlyIncome, oldLoan, null);
        try {
            requestService.addRequest(request1);
            response.sendRedirect(request.getContextPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "insert" :
                createRequest(request, response);
                break;

        }

    }


}
