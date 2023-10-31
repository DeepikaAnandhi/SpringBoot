<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PDF App</title>
   <style>
        a{
            text-align: center;
            font-weight: bold;
            color: white;
            background-color: cornflowerblue;
            border: 1px solid blue;
            display:inline-flex
            
        }
        body{
            text-align: center;
            background-color: aliceblue;
        }
        a:hover{
            color: black;
        }

    </style>
</head>
<body>
   <h1>Employee Details</h1> 

   <div>
	<a href="report?type=pdf">Download PDF</a>

	<a href="report?type=excel">Download Excel</a>
</div>


</body>
</html>