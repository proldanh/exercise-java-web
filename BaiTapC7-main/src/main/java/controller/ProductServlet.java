package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.DetailProduct;
import model.Product;
import model.ProductRepository;

import java.io.IOException;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() {
        productRepository = new ProductRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "/index.jsp";  // Mặc định điều hướng đến index.jsp

        switch (action) {
            case "listSP":
                req.setAttribute("products", productRepository.getProducts());
                break;

            case "addProduct":
                addProduct(req);
                url = "/YourCart.jsp";
                break;

            case "removeProduct":
                removeProduct(req);
                url = "/YourCart.jsp";
                break;

            case "updateProduct":
                updateProduct(req);
                url = "/YourCart.jsp";
                break;

            case "checkOut":
                url = "/CheckOut.jsp";
                break;

            default:
                break;
        }

        req.getRequestDispatcher(url).forward(req, resp);
    }

    private void addProduct(HttpServletRequest req) {
        String idProduct = req.getParameter("id_product");
        Product product = productRepository.getProduct(idProduct);
        DetailProduct detailProduct = new DetailProduct(product);
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        // Khởi tạo giỏ hàng nếu chưa tồn tại
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        cart.addProduct(detailProduct);
    }

    private void removeProduct(HttpServletRequest req) {
        String idProduct = req.getParameter("id_product");
        Product product = productRepository.getProduct(idProduct);
        DetailProduct detailProduct = new DetailProduct(product);
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null) {
            cart.removeProduct(detailProduct);
        }
    }

    private void updateProduct(HttpServletRequest req) {
        String idProduct = req.getParameter("id_product");
        String quantityStr = req.getParameter("quantity");
        int quantity = Integer.parseInt(quantityStr);
        Product product = productRepository.getProduct(idProduct);
        DetailProduct detailProduct = new DetailProduct(product);
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null) {
            cart.updateProduct(detailProduct, quantity);
        }
    }
}