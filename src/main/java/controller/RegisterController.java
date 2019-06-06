package controller;

import com.google.gson.Gson;
import entity.Member;
import model.MemberModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {
    private static MemberModel  model= new MemberModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member member = new Member();
        req.setAttribute("Member", member);
        req.getRequestDispatcher("/member/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullName");
        String address = req.getParameter("address");
        String role = req.getParameter("role");
        Member member = new Member();
        member.setUsername(name);
        member.setPassword(password);
        member.setEmail(email);
        member.setFullName(fullName);
        member.setAddress(address);
        member.setRole(role);
        model.save(member);
        resp.getWriter().println(new Gson().toJson(member));
    }
}
