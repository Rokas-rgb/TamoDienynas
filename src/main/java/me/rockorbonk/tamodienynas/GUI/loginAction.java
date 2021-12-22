package me.rockorbonk.tamodienynas.GUI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String uname = null;
    String pwd = null;

    public loginAction() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uname = request.getParameter(uname);
        pwd = request.getParameter(pwd);

        System.out.println("Username : "+uname);
        System.out.println("Password : "+pwd);
    }
}
