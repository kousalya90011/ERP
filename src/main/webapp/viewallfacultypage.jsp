<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View All Faculty</title>
    <style>
        body {
            background-color: #f4f4f4;
            color: #333;
            font-family: 'Arial', sans-serif;
        }
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px 10%;
            background-color: #fff;
        }
        .logo img {
            width: 50px;
        }
        nav ul {
            list-style: none;
            display: flex;
            gap: 40px;
        }
        nav ul li a {
            text-decoration: none;
            color: #333;
            font-weight: bold;
            font-size: 18px;
            text-transform: uppercase;
        }
        .hero {
            text-align: center;
            padding: 40px;
            background-color: #fff;
            border-bottom: 1px solid #ccc;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            text-align: left;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
        }
        th {
            background-color: #333;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f4f4f4;
        }
    </style>
</head>
<body>

<header>
    <div class="logo">
        <img src="<%= request.getContextPath() %>/images/college.png" alt="Logo">
    </div>
    <nav>
        <ul>
            <li><a href="<%= request.getContextPath() %>/admin/">Home</a></li>
            <li><a href="<%= request.getContextPath() %>/about.jsp">About Us</a></li>
            <li><a href="<%= request.getContextPath() %>/service.jsp">Service</a></li>
        </ul>
    </nav>
</header>

<section class="hero">
    <h1>Faculty List</h1>
</section>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Department</th>
            <th>Designation</th>
            <th>Salary</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="faculty" items="${facultyList}">
            <tr>
                <td>${faculty.id}</td>
                <td>${faculty.name}</td>
                <td>${faculty.email}</td>
                <td>${faculty.department}</td>
                <td>${faculty.designation}</td>
                <td>${faculty.salary}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
