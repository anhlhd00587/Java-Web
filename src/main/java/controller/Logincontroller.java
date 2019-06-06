package controller;

import entity.Member;
import model.MemberModel;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class Logincontroller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            for (Cookie cookie :
                    cookies){
                System.out.println(cookie.getName()+ " - " + cookie.getValue() + " - " + cookie.getDomain());
            }
        }

        HttpSession session = req.getSession();
        Member member = (Member) session.getAttribute("currentLoggedIn");
        req.setAttribute("member", member);
        req.getRequestDispatcher("/member/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String inputPassword = req.getParameter("password");
        String inputUsername = req.getParameter("username");
        MemberModel model = new MemberModel();
        Member member = model.findByUsernameAndStatus(inputUsername, Member.Status.ACTIVE);
        if (member == null){
            resp.setStatus(404);
            resp.getWriter().println("Tài khoản không tồn tại hoạc đã bị xóa!");
        }else {
            //mã hóa pass vs salt lấy ra từ db trước khi so sánh.
            if (inputPassword.equals(member.getPassword())){
                HttpSession session = req.getSession();
                session.setAttribute("currentLoggedIn", member);
                resp.setStatus(200);
                resp.getWriter().println("Đăng nhập thành công !");
            }else {
                resp.setStatus(401);
                resp.getWriter().println("Sai thông tin tài khoản .");
            }
        }
    }
}
