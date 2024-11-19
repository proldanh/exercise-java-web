<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
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
    <form action="product" method="post" class="mb-4">
        <input type="hidden" name="action" value="listSP">
        <h1 class="mt-2 fw-bold highlighted-title">CD list</h1>
        <button type="submit" class="btn btn-primary">Load Product</button>
    </form>
    <table class="table table-hover table-striped table-bordered">
        <tr class="table-info">
            <th>Description</th>
            <th class="text-center">Price</th>
            <th></th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.name}</td>
                <td class="text-center">$${product.price}</td>
                <td class="text-center">
                    <form action="product" method="post">
                        <input type="hidden" value="addProduct" name="action">
                        <input type="hidden" value="${product.id}" name="id_product">
                        <button type="submit" class="btn btn-success">Add To Cart</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
