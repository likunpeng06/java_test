import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by qatang on 14-3-4.
 */
public class ServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ClassLoader loader = this.getClass().getClassLoader();
        while (loader != null) {
            out.println(loader.getClass().getName() + "<br />");
            loader = loader.getParent();
        }
        out.println(loader);
        out.close();
    }
}
