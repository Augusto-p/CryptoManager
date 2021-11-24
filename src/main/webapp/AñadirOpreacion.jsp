<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="modelo.*"%>
<%@page import="entidades.MonedaEntidad"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="es">
<head>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
    <link rel="stylesheet" type="text/css" href="CSS/TablaRes/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="CSS/TablaRes/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="CSS/TablaRes/animate.css">
    <link rel="stylesheet" type="text/css" href="CSS/TablaRes/select2.min.css">
    <link rel="stylesheet" type="text/css" href="CSS/TablaRes/perfect-scrollbar.css">
    <link rel="stylesheet" type="text/css" href="CSS/TablaRes/util.css">
    <link rel="stylesheet" type="text/css" href="CSS/TablaRes/main.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/add.css">
    <link rel="shortcut icon" href="../css/bitlogo.ico" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cryptomanager</title>
</head>
<body>
	<div class="baner">
        <div>
            <h1>CryptoManager</h1>
            <h2>Añadir Transaccion</h2>
        </div>

    </div>
    <div id="formdiv">
        <form action="${pageContext.request.contextPath}/CrearOperacion" method="post">
            <h3 for="nik">Nick:</h3>
            <input class="InputText" type="text" name="nik" id="nik">
            <h3 for="cant">Cantidad:</h3>
            <input class="InputText" type="number" name="cant" id="cant">
            <h3 for="precT">Precio Total</h3>
            <input class="InputText" type="number" name="precT" id="precT">
            <h6>Tipo de Operación:</h6>
            <h3 for="">Compra</h3>
            <input class="InputRadio" type="radio" name="oper" id="Compra" value="Compra" checked>

            <h3 for="">Venta</h3>
            <input class="InputRadio" type="radio" name="oper" id="Venta" value="Venta">

            <button type="submit">Enviar transaccion</button>
        </form>
    </div>

	 
</body>
</html>