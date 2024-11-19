package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<DetailProduct> CartProducts = new ArrayList<DetailProduct>();
    public List<DetailProduct> getCartProducts() {
        return CartProducts;
    }
    public void setCartProducts(List<DetailProduct> CartProducts) {
        this.CartProducts = CartProducts;
    }

    //Thêm sản phẩm
    public void addProduct(DetailProduct product) {
        //Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng hay chưa
        for (DetailProduct x : CartProducts) {
            if (x.getProduct().getId() == product.getProduct().getId()) {
                // Sản phẩm đã tồn tại trong giỏ hàng
                return;
            }
        }
        // Nếu không tồn tại, thêm sản phẩm vào giỏ hàng
        CartProducts.add(product);
    }

    //Cập nhật số lượng sản phẩm
    //Đứng trong giỏ hàng
    public void updateProduct(DetailProduct product, int quantity) {
        for(DetailProduct x : CartProducts){
            if (x.getProduct().getId() == product.getProduct().getId()) {
                // Cập nhật số lượng sản phẩm
                x.setQuantity(quantity);
                return;
            }
        }
    }

    //Xóa sản phẩm
    public void removeProduct(DetailProduct product) {
        for(DetailProduct x : CartProducts){
            if (x.getProduct().getId() == product.getProduct().getId()) {
                CartProducts.remove(x);
                return;
            }
        }
    }
}
