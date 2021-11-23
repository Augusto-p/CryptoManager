<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="modelo.*"%>
<%@page import="entidades.MonedaEntidad"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="es">
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="CSS/TablaRes/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="CSS/TablaRes/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="CSS/TablaRes/animate.css">
    <link rel="stylesheet" type="text/css" href="CSS/TablaRes/select2.min.css">
    <link rel="stylesheet" type="text/css" href="CSS/TablaRes/perfect-scrollbar.css">
    <link rel="stylesheet" type="text/css" href="CSS/TablaRes/util.css">
    <link rel="stylesheet" type="text/css" href="CSS/TablaRes/main.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/add.css">
    <link rel="shortcut icon" href="CSS/bitlogo.ico" />
    <title>CryptoManager</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<div class="baner">
        <div>
            <h1>CryptoManager</h1>
            <h2>Añadir Moneda</h2>
        </div>
    </div>
    <div id="formdiv">
        <form action="${pageContext.request.contextPath}/CrearMoneda" method="post">
            <h3>Nik:</h3>
            <input class="InputText" type="text" name="nik" id="nik">
            <h3>Nombre:</h3>
            <input class="InputText" type="text" name="name" id="name">
            <h3>Logo:</h3>
            <input class="InputText" type="text" name="logo" id="logo">
            <button type="submit">Añadir Moneda</button>
        </form>
    </div>
	 
</body>
</html>