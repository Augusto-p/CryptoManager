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
    <link rel="stylesheet" href="CSS/addtrans.css">
    <link rel="shortcut icon" href="CSS/bitlogo.ico" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cryptomanager</title>
</head>
<body>
    <div class="baner">
        <div>
            <h1>CryptoManager</h1>
            <h2>Añadir Operacion</h2>
        </div>

    </div>
    <div id="formdiv">
        <form action="${pageContext.request.contextPath}/CrearOperacion" method="post" class="formulario">
            <h3 for="nik">Nick:</h3>
            <input class="InputText" type="text" name="nik" id="nik" autocomplete="off">
            <h3 for="cant">Cantidad:</h3>
            <input class="InputText" type="number" name="cant" id="cant" autocomplete="off">
            <h3 for="precT">Precio Total:</h3>
            <input class="InputText" type="number" name="precT" id="precT" autocomplete="off">
            <h6>Tipo de Operación:</h6>
            <div class="radio">
                <input type="radio" name="oper" id="buy" value="Compra" checked>
                <label for="buy">Compra</label>
                <input type="radio" name="oper" id="sell" value="Venta">
                <label for="sell">Venta</label>
            </div>
            <button type="submit">Añadir Transaccion</button>
        </form>
    </div>
    <div class="Botones">
        <div class="butts">
            <a id="coin" href="${pageContext.request.contextPath}/ListarMonedas">Monedas</a>
            <a id="opp" href="${pageContext.request.contextPath}/ListarTransaciones">Operaciónes</a>
        </div>
    </div>


</body>

</html>