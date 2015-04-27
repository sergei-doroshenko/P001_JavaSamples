package sd.controllers;

import sd.dao.ProductDao;
import sd.domain.Product;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Sergei on 27.04.2015.
 */
public class ProductAllController extends HttpServlet {
    private final String PAGE_OK = "products.jsp";
    private final String PAGE_ERROR = "error.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        ProductDao dao = (ProductDao) context.getAttribute("productDao");
        List<Product> productList = dao.findAll();
        resp.setContentType("text/html");
        String message = "Products:";
        // Actual logic goes here.
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + "</h1>");
        out.println("</br>");
        for (Product product : productList) {
            out.println("<div>" + " " + product.getId() + " " + product.getProdName() + " </div>");
        }
    }
}
