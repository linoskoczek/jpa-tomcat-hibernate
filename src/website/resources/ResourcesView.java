package website.resources;

import tpo4.Resource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/resourcesView")
public class ResourcesView extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //if(req.getAttribute("model") != null) resp.sendError(404);
        System.out.println(req.getAttribute("model"));
        ResourcesModel model = (ResourcesModel) req.getAttribute("model");
        List<Resource> resourceList = model.getResources();

        PrintWriter writer = resp.getWriter();
        for (Resource resource :
                resourceList) {
            writer.println(resource.getName());
        }
        writer.close();
    }
}
