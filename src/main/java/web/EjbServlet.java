package web;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/ejbServlet")
public class EjbServlet extends HttpServlet {
    @EJB
    FileReaderEjb reader;

    private static final String PATH = System.getProperty("user.dir");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File dir = new File(PATH);
        reader.readFiles(dir);
        String result = reader.getResult();
        req.setAttribute("result", result);
        req.getServletContext().getRequestDispatcher("/files.jsp").forward(req, resp);
    }
}
