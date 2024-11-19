package model;

public class ProductRepository {
    private Product[] products = {
            new Product("1", "86 (the band) - True Life Songs and Pictures", 14.95),
            new Product("2", "Paddiefoot - The first CD", 12.95),
            new Product("3", "Paddiefoot - The second CD", 14.95),
            new Product("4", "Joe Rut - Genuine Wood Grained Finish", 14.95),
    };
    //Lấy toàn bộ sản phẩm
    public Product[] getProducts() {
        return products;
    }
    //Lấy sản phẩm theo id
    public Product getProduct(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}
