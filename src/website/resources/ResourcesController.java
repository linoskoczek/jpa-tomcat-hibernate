package website.resources;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resources")
public class ResourcesController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkSession(req, resp);

        ResourcesLogic logic = new ResourcesLogic((String) req.getSession().getAttribute("login"));
        ResourcesModel model = logic.getResult();

        req.setAttribute("model", model);
        ServletContext context = getServletContext();
        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/resourcesView");
        requestDispatcher.forward(req, resp);
    }

    private void checkSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getSession().getAttribute("login") == null)
            resp.sendRedirect("/login");
    }
}
