<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="modelo.*"%>
<%@page import="entidades.MonedaEntidad"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="es">
<head>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="CSS/TablaRes/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="CSS/TablaRes/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="CSS/TablaRes/animate.css">
	<link rel="stylesheet" type="text/css" href="CSS/TablaRes/select2.min.css">
	<link rel="stylesheet" type="text/css" href="CSS/TablaRes/perfect-scrollbar.css">
	<link rel="stylesheet" type="text/css" href="CSS/TablaRes/util.css">
	<link rel="stylesheet" type="text/css" href="CSS/TablaRes/main.css">
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
	<link rel="stylesheet" href="CSS/mone.css">
	<link rel="shortcut icon" href="CSS/bitlogo.ico" />
	<title>Cryptomanager</title>
</head>
<body>
	 
	 
</body>
<body>
	<div class="baner">
        <div>
            <h1>CryptoManager</h1>
            <h2>Monedas</h2>
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
									<th class="cell100 columna1">Imagen nombre nick</th>
									<th class="cell100 columna2">Cantidad</th>
									<th class="cell100 columna3">Precio Promedio de Compra</th>
									<th class="cell100 columna4">Precio Promedio de Venta</th>
									<th class="cell100 columna5">no se ya se me me ocurrira algo</th>
								</tr>
							</thead>
						</table>
					</div>
					<div class="table100-body js-pscroll ps ps--active-y">
						<table>
							<tbody>
								<%
									ArrayList<MonedaEntidad> lista = (ArrayList<MonedaEntidad>) request.getAttribute("monedas");
									for (MonedaEntidad item : lista) {
								%>
								<tr class="row100 body">
									<td class="cell100 columna1"><%=item.getName()%></td>
									<td class="cell100 columna2"><%=item.getCantidad()%></td>
									<td class="cell100 columna3"><%=item.getPrecio_pro_com()%></td>
									<td class="cell100 columna4"><%=item.getPrecio_pro_ven()%></td>
									<td class="cell100 columna5"><%=item.getNik()%></td>
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
		<script src="../TablaRes/jquery-3.2.1.min.js.descarga"></script>
		<script src="../TablaRes/popper.js.descarga"></script>
		<script src="../TablaRes/bootstrap.min.js.descarga"></script>
		<script src="../TablaRes/select2.min.js.descarga"></script>
		<script async="" src="../TablaRes/js"></script>
		<script src="../TablaRes/perfect-scrollbar.min.js.descarga"></script>
		<script>
			$('.js-pscroll').each(function () {
				var ps = new PerfectScrollbar(this);

				$(window).on('resize', function () {
					ps.update();
				})
			});
		</script>
		<script>
			window.dataLayer = window.dataLayer || [];
			function gtag() { dataLayer.push(arguments); }
			gtag('js', new Date());

			gtag('config', 'UA-23581568-13');
		</script>
		<script src="../TablaRes/main.js.descarga"></script>
		<script defer="" src="../TablaRes/beacon.min.js.descarga"
			data-cf-beacon="{&quot;rayId&quot;:&quot;6af42311b920d7d9&quot;,&quot;token&quot;:&quot;cd0b4b3a733644fc843ef0b185f98241&quot;,&quot;version&quot;:&quot;2021.11.0&quot;,&quot;si&quot;:100}"
			crossorigin="anonymous"></script>
	</div>
			
	<div class="Botones">
		<div class="butts">
			<a id="coin" href="">Monedas</a>
			<a id="opp" href="${pageContext.request.contextPath}/ListarTransaciones">Operaciónes</a>
		</div>
	</div>
	
</body>
</html>