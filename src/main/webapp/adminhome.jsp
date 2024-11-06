<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ERP Admin Home</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Arial', sans-serif;
        }
        body {
            background-color: #f4f4f4;
            color: #333;
            overflow-x: hidden;
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
        .quarter-circle {
            width: 200px;
            height: 200px;
            background-color: #dcdcdc;
            border-radius: 0 0 200px 0;
            position: absolute;
            top: 0;
            left: 0;
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
            transition: color 0.3s ease;
        }
        nav ul li a:hover {
            color: #8b5e3c;
        }
        .sign-in-btn {
            padding: 8px 16px;
            background-color: #333;
            color: #fff;
            text-decoration: none;
            border-radius: 20px;
        }
        .hero {
            text-align: center;
            padding: 40px;
            background-color: #fff;
            border-bottom: 1px solid #ccc;
        }
        .hero h1 {
            font-size: 2.5rem;
            font-weight: bold;
            margin-bottom: 10px;
        }
        .hero p {
            color: #8b5e3c;
            font-size: 1.2rem;
        }
        .tabs {
            display: flex;
            justify-content: center;
            background-color: #333;
            padding: 10px;
        }
        .tabs a {
            padding: 10px 20px;
            margin: 0 5px;
            color: #fff;
            text-decoration: none;
            font-weight: bold;
            text-transform: uppercase;
            background-color: #333;
            border-radius: 5px;
        }
        .tabs a:hover {
            background-color: #555;
        }
        .action-buttons {
            display: flex;
            justify-content: center;
            gap: 30px;
            margin: 30px 0;
        }
        .action-card {
            background-color: #777;
            color: #fff;
            width: 250px;
            height: 150px;
            border-radius: 10px;
            text-align: center;
            padding: 20px;
            font-weight: bold;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s;
        }
        .action-card:hover {
            transform: scale(1.05);
        }
        .action-card button {
            padding: 8px 16px;
            margin-top: 20px;
            background-color: #000;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .action-card button:hover {
            background-color: #8b5e3c;
        }
       .form-container {
    display: flex;
    justify-content: center;
    align-items: center; /* Centers the form vertically */
    padding: 40px;
    background-color: #222;
    color: #fff;
    border-radius: 10px;
    margin: 20px auto; /* Centers the container horizontally */
    box-shadow: 0 0 10px rgba(255, 255, 255, 0.1);
    width: 60%; /* Adjust width as needed */
    max-width: 600px; /* Set a max-width */
    height: auto; /* Allows height to adjust based on content */
}
       
        h2 {
            color: #fff;
        }
       .form-group {
    margin-bottom: 20px;
    display: flex;
    justify-content: space-between;
    width: 100%;
    align-items: center;
}
       
        .form-group label {
            color: #fff;
            flex: 1;
            margin-right: 10px;
        }
        .form-group input,
        .form-group select {
            flex: 2;
            padding: 10px;
            border-radius: 5px;
            border: none;
        }
        .submit-button {
            background-color: #f7bc08;
            color: #000;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
        }
        .submit-button:hover {
            background-color: #e6a600;
        }
         .dropdown {
            position: relative;
            display: inline-block;
        }
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #333;
            min-width: 160px;
            box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
            z-index: 1;
            border-radius: 5px;
        }
        .dropdown-content a {
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            display: block;
            font-weight: bold;
            text-transform: uppercase;
        }
        .dropdown-content a:hover {
            background-color: #555;
        }
        .dropdown:hover .dropdown-content {
            display: block;
        }
    </style>
</head>
<body>

<header>
    <div class="quarter-circle"></div>
    <div class="logo">
        <img src="<%= request.getContextPath() %>/images/college.png" alt="Logo">
    </div>
    <nav>
        <ul>
            <li><a href="<%= request.getContextPath() %>/home.jsp">Home</a></li>
            <li><a href="<%= request.getContextPath() %>/about.jsp">About Us</a></li>
            <li><a href="<%= request.getContextPath() %>/service.jsp">Service</a></li>
        </ul>
    </nav>
</header>

<section class="hero">
    <h1>WELCOME, ADMIN</h1>
</section>

<div class="tabs">
    <a href="#">Basic Operations</a>
    <a href="#">Student Services</a>
    <div class="dropdown">
        <a href="#">Faculty Services</a>
        <div class="dropdown-content">
            <a href="/viewallfacultypage">View Faculty</a>
            <a href="/deletefaculty">Delete Faculty</a>
        </div>
    </div>
    <a href="postnotification">Notifications</a>
    <a href="#">Other Operations</a>
</div>

<div class="action-buttons">
    <div class="action-card">
        <div>VIEW STUDENT PROFILE'S</div>
        <button>ACCESS</button>
    </div>
    <div class="action-card">
        <div>VIEW FACULTY PROFILES</div>
        <button>ACCESS</button>
    </div>
</div>

</body>
</html>
