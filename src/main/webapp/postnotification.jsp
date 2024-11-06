<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ERP System</title>
    <style>
        body {
            justify-content: center;
            margin: 0;
        }
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Arial', sans-serif;
        }
        body {
            background-color: transparent;
            color: #333;
            overflow-x: hidden;
        }
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px 10%;
            background-color: #fff;
            position: relative;
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
        .quarter-circle-right {
            width: 300px;
            height: 250px;
            margin-top: 800px;
            margin-right: -130px;
            background-color: #dcdcdc;
            border-radius: 150px;
            position: absolute;
            top: 0;
            right: 0;
        }
        .background-image {
            background-image: url('<%= request.getContextPath() %>/images/image.png'); 
            background-size: cover;
            background-position: center;
            border-radius: 50px;
            z-index: 0;
            height: 50vh;
            margin-left: 32px;
            position: absolute;
            top: 490px;
            left: 0;
            right: 0;
            width: 95%;
        }
        .tabs, .tabcontent {
            position: relative;
            z-index: 10;
        }
        .tab button {
            position: relative;
            z-index: 20;
        }
        nav ul {
            list-style: none;
            display: flex;
            gap: 40px;
            margin-top: 20px;
            transition: all 0.3s ease;
        }
        nav ul li a {
            text-decoration: none;
            color: #333;
            font-weight: bold;
            font-size: 18px;
            text-transform: uppercase;
            transition: color 0.3s ease, font-size 0.3s ease;
        }
        nav ul li a:hover {
            color: #8b5e3c;
            font-size: 19px;
        }
        .sign-in-btn {
            padding: 8px 16px;
            background-color: #333;
            color: #fff;
            text-decoration: none;
            border-radius: 20px;
            font-size: 1rem;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }
        .sign-in-btn:hover {
            background-color: #8b5e3c;
            transform: scale(1.05);
        }
        .hero {
            text-align: center;
            padding: 80px 20px;
            position: relative;
            z-index: 1;
        }
        .hero h1 {
            font-size: 3rem;
            font-weight: bold;
            margin-bottom: 10px;
            animation: fadeInUp 0.8s ease;
        }
        .hero p {
            color: #8b5e3c;
            font-size: 1.2rem;
            animation: fadeInUp 1s ease;
        }
        .userForm {
            display: flex;
        }
        .form-container {
            margin-left: 390px;
            align: center;
            background-color: #222; /* Darker background for the form */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(255, 255, 255, 0.1);
            width: 600px; /* Fixed width for the form */
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #fff;
        }
        .form-group {
            display: flex;
            justify-content: space-between; /* Distributes space between label and input */
            align-items: center; /* Vertically centers items */
            margin-bottom: 15px;
            margin-top: 20px;
        }
        label {
            flex: 1; /* Takes up 30% of the space */
            margin-right: 20px; /* Space between label and input */
            color: white;
        }
        input, select {
            flex: 2; /* Takes up 70% of the space */
            padding: 10px;
            border: none;
            border-radius: 5px;
            transition: background-color 0.3s, color 0.3s; /* Smooth transition on hover */
        }
        input:focus, select:focus {
            background-color: #444; /* Darker background on focus */
            color: #fff; /* White text color on focus */
        }
        .submit-button {
            background-color: #f7bc08; /* Gold color */
            color: #000; /* Black text color */
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s, transform 0.3s; /* Smooth transition on hover */
            font-weight: bold;
        }
        .submit-button:hover {
            background-color: #e6a600; /* Darker gold on hover */
            transform: scale(1.05); /* Slightly grow button on hover */
        }
        /* Keyframes for animations */
        @keyframes fadeInUp {
            0% {
                opacity: 0;
                transform: translateY(20px);
            }
            100% {
                opacity: 1;
                transform: translateY(0);
            }
        }
        .conditional-form {
            margin-top: 20px;
            background-color: #333;
            padding: 20px;
            border-radius: 10px;
        }
    </style>
</head>
<body>

<header>
    <div class="quarter-circle"></div>
    <div class="quarter-circle-right"></div> <!-- Quarter circle on the right side -->
    <div class="logo">
        <img src="<%= request.getContextPath() %>/images/college.png" alt="Logo"> <!-- Dynamically load logo image -->
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
    <div class="dots">
        <span class="dot"></span>
        <span class="dot"></span>
        <span class="dot"></span>
    </div>
    <h1>ERP SYSTEM</h1>
    <p>Welcome to our ERP system where you can get the required data of yours.</p>
</section>

<div class="form-container" align="center">
	<h2 align="center">Post Notification</h2>
    <form id="postNotification" action="notification" method="post">
        <div class="form-group">
            <label for="role">Role:</label>
            <select id="role" name="role" required>
                <option value="" disabled selected>Select your role</option>
                <option value="STUDENT">Student</option>
                <option value="FACULTY">Faculty</option>
            </select>
        </div> <!-- Corrected closing div tag -->

        <div class="form-group">
            <label for="mesg">Message:</label>
            <input type="text" id="mesg" name="mesg" required/>
        </div>
         <button type="submit" class="submit-button">POST</button>
    </form>
</div>

</body>
</html>
