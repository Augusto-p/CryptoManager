<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="modelo.*"%>
<%@page import="entidades.OperacionEnidad"%>
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
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
	<link rel="stylesheet" href="CSS/trans.css">
	<link rel="shortcut icon" href="CSS/bitlogo.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cryptomanager</title>
</head>
<body>
	 <div class="baner">
        <div>
            <h1>CryptoManager</h1>
            <h2>Operaciones</h2>
        </div>

    </div>
    <div class="limiter">
        <div class="container-table100">
            <div class="wrap-table100">
                <div class="table100 ver3 m-b-110">
                    <div class="table100-head">
                        <table>
                            <thead>
                                <tr class="row100 head">
                                    <th class="cell100 columna1">Imágen Nombre Nik</th>
                                    <th class="cell100 columna2">Cantidad</th>
                                    <th class="cell100 columna3">Fecha</th>
                                    <th class="cell100 columna4">Precio Total</th>
                                    <th class="cell100 columna5">Precio Unitario</th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                    <div class="table100-body js-pscroll ps ps--active-y">
                        <table>
                            <tbody>	
      							<%
									ArrayList<OperacionEnidad> lista = (ArrayList<OperacionEnidad>) request.getAttribute("Transa");
									for (OperacionEnidad item : lista) {
										String url = "data:image/png;base64,"+item.getImg();
								%>
      
                                <tr class="row100 body">
                                    <td class="cell100 columna1 "><div>
                                            <img class="imgclass" src=<%=url %> alt="">
                                            <span class="nameclass"><%=item.getNombre()%></span>
                                            <span class="nickclass <%=item.getMode()%>"><%=item.getNik()%></span>
                                        </div>
                                    </td>
                                    <td class="cell100 columna2"><%=item.getCantidad()%></td>
                                    <td class="cell100 columna3"><%=item.getFecha()%></td>
                                    <td class="cell100 columna4"><%=item.getPrice()%></td>
                                    <td class="cell100 columna5"><%=item.getPrecio_uni()%></td>
                                </tr>
                 			<%
									}
								%>
                            </tbody>
                        </table>
                        <div class="ps__rail-x" style="left: 0px; bottom: -91px;">
                            <div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div>
                        </div>
                        <div class="ps__rail-y" style="top: 0px; height: 415px; right: 5px;">
                            <div class="ps__thumb-y" tabindex="0" style="top: 0px; height: 207px;"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="CSS/TablaRes/jquery-3.2.1.min.js.descarga"></script>
        <script src="CSS/TablaRes/popper.js.descarga"></script>
        <script src="CSS/TablaRes/bootstrap.min.js.descarga"></script>
        <script src="CSS/TablaRes/select2.min.js.descarga"></script>
        <script async="" src="CSS/TablaRes/js"></script>
        <script src="CSS/TablaRes/perfect-scrollbar.min.js.descarga"></script>
        <script>
            $('.js-pscroll').each(function() {
                var ps = new PerfectScrollbar(this);

                $(window).on('resize', function() {
                    ps.update();
                })
            });
        </script>
        <script>
            window.dataLayer = window.dataLayer || [];

            function gtag() {
                dataLayer.push(arguments);
            }
            gtag('js', new Date());

            gtag('config', 'UA-23581568-13');
        </script>
        <script src="CSS/TablaRes/main.js.descarga"></script>
        <script defer="" src="CSS/TablaRes/beacon.min.js.descarga" data-cf-beacon="{&quot;rayId&quot;:&quot;6af42311b920d7d9&quot;,&quot;token&quot;:&quot;cd0b4b3a733644fc843ef0b185f98241&quot;,&quot;version&quot;:&quot;2021.11.0&quot;,&quot;si&quot;:100}" crossorigin="anonymous"></script>
    </div>
    <div class="Botones">
        <div class="butts">
            <a id="coin" href="${pageContext.request.contextPath}/ListarMonedas">Monedas</a>
            <a id="add" href="${pageContext.request.contextPath}/AddOperacion">Añadir</a>
            <a id="opp" href="">Operaciónes</a>
        </div>
    </div>
</body>
</html>