<%@ page import="java.util.AbstractList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Person" %>
<%@ page import="javax.xml.xpath.XPathEvaluationResult" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="style.css" type="text/css">
</head>

<body>
<form class="survey-form" action="" method="post">
    <input type="hidden" name="action" value="join">
    <h1 style="color: teal">Thank You Very Much</h1>
    <p>Here is the information that you entered:</p>
    <%
        Person person = (Person) request.getAttribute("person");
    %>
    <table border="1" style="border-collapse: collapse; text-align: center" >
        <tr>
            <th class="titleTableJoin">Email:</th>
            <td class="inputTable"><%=person.getEmail()%></td>
        </tr>
        <tr>
            <th class="titleTableJoin">First Name:</th>
            <td><%=person.getFirstName()%></td>
        </tr>
        <tr>
            <th class="titleTableJoin">Last Name:</th>
            <td><%=person.getLastName()%></td>
        </tr>
        <tr>
            <th class="titleTableJoin">Date Of Birth:</th>
            <td>
                <%
                    Date dateOfBirth = person.getDateOfBirth();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    String formattedDate = sdf.format(dateOfBirth);
                %>
                <%= formattedDate %>
            </td>
        </tr>
        <tr>
            <th class="titleTableJoin">You know us through:</th>
            <td><%=person.getBietDenThongQua()%></td>
        </tr>
        <tr>
            <th class="titleTableJoin">Your choice receiving announcements:</th>
            <td>
                <ul>
                    <%
                        List<String> luaChonNhanThongBaos = person.getNhanThongBao();
                        for (String luaChon : luaChonNhanThongBaos) {
                    %>
                    <li><%= luaChon %></li>
                    <% } %>
                </ul>
            </td>
        </tr>
        <tr>
            <th class="titleTableJoin">We will contact you via:</th>
            <td>
                <ul>
                    <%
                        List<String> phuongThucLienLacs = person.getLienHe();
                        for (String phuongThuc : phuongThucLienLacs) {
                    %>
                    <li><%= phuongThuc %></li>
                    <% } %>
                </ul>
            </td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Return">
</form>
</body>
</html>
