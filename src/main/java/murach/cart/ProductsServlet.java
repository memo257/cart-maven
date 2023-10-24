package murach.cart;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

import murach.data.ProductIO;
import murach.business.Product;

public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String path = getServletContext().getRealPath("/WEB-INF/products.txt");
        ArrayList<Product> products = ProductIO.getProducts(path);
        session.setAttribute("products", products);
        
        request.setAttribute("result", "This is the result of the servlet call");


        
//        String pathindex = this.getServletContext().getRealPath("/index.jsp");
//        
//        System.out.println("path index.jsp: " + pathindex);

                
                
        String url = "/index.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
