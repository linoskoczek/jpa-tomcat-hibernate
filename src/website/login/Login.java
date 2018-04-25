package website.login;

import repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static website.Utilities.isGoodPost;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkParameters(req, resp);
        String login = req.getParameter("login"), password = req.getParameter("password");

        if(doLogin(req, login, password))
            resp.sendRedirect("/resources");
        else
            resp.sendRedirect("/");
    }

    private boolean doLogin(HttpServletRequest req, String login, String password) {
        UserRepository ur = new UserRepository();

        if (ur.checkPassword(login, password)) {
            HttpSession session = startNewSession(req);
            assignLoginToSession(session, login);
            return true;
        } else {
            return false;
        }
    }

    private void checkParameters(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(!isGoodPost(req.getParameter("login")) || !isGoodPost(req.getParameter("password")))
            resp.sendRedirect("/");
    }

    private void assignLoginToSession(HttpSession session, String login) {
        session.setAttribute("login", login);
    }

    private HttpSession startNewSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session!=null && !session.isNew()) {
            session.invalidate();
        }
        return request.getSession(true);
    }
}