package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //viene del enlace
        //obtener acceso al objeto session
        HttpSession ses =request.getSession();
        //eliminar session
        ses.invalidate();
        //trasnferir el control al index.jsp
        response.sendRedirect("index.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos datos del formulario
            String producto = request.getParameter("producto");
            //obtener acceso al objeto session
            HttpSession ses = request.getSession();
            //obtener acceso a la lista
            ArrayList<String> lista =(ArrayList<String>) ses.getAttribute("lista");
            //adicionamos a la lista
            lista.add(producto);
            response.sendRedirect("index.jsp");
    }
    
    
        }
 

