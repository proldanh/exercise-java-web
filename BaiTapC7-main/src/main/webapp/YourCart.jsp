<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Murachs Java Servlets and JSP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <link href="main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <h1 class="mt-2 fw-bold highlighted-title">Your Cart</h1>
    <table class="table table-hover table-striped table-bordered">
        <thead>
        <tr class="text-center">
            <th>Quantity</th>
            <th>Description</th>
            <th>Price</th>
            <th>Amount</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty cart.cartProducts}">
            <c:forEach var="detailProduct" items="${cart.cartProducts}">
                <tr>
                    <form action="product" method="post" class="d-inline">
                        <td>
                            <div class="input-group" style="display: flex; align-items: center;">
                                <input type="hidden" name="id_product" value="${detailProduct.product.id}">
                                <input type="hidden" name="action" value="updateProduct">
                                <input type="text" class="form-control form-control-sm text-center" name="quantity" value="${detailProduct.quantity}" style="width: 30px;">
                                <input type="submit" class="btn btn-primary" value="Update" style="margin-left: 10px;">
                            </div>
                        </td>
                    </form>

                    <td>${detailProduct.product.name}</td>
                    <td class="text-center">$${detailProduct.product.price}</td>
                    <td class="text-center">
                        $<fmt:formatNumber value="${detailProduct.quantity * detailProduct.product.price}" pattern="#,##0.00"/>
                    </td>
                    <td class="text-center">
                        <form action="product" method="post" class="d-inline">
                            <input type="hidden" name="action" value="removeProduct">
                            <input type="hidden" name="id_product" value="${detailProduct.product.id}">
                            <input type="submit" value="Remove" class="btn btn-danger">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
    <p class="mt-3"><strong>To change the quantity</strong>, enter the new quantity and click on the Update button</p>
    <form action="product" method="post">
        <input type="submit" class="btn btn-secondary me-2" value="Continue Shopping">
        <input type="hidden" name="action" value="listSP">
    </form>
    <form action="product" method="post">
        <input type="hidden" name="action" value="checkOut">
        <input type="submit" class="btn btn-primary" value="Checkout">
    </form>
</div>
</body>
</html>
