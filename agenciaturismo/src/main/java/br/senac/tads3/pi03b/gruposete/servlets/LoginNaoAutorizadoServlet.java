///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.senac.tads3.pi03b.gruposete.servlets;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// *
// * @author Rafael Ferreira
// */
//@WebServlet(name = "LoginNaoAutorizadoServlet", urlPatterns = {"/LoginNaoAutorizado"})
//public class LoginNaoAutorizadoServlet extends HttpServlet {
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.getRequestDispatcher("jsp/erroNaoAutorizado.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }
//}
