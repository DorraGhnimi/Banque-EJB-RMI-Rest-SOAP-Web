<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>myBanqueEJB</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
</head>
<body>
	<div >
		<div class="panel panel-primary">
			<div class="panel-heading"><h1>BanqueEJB</h1></div>
			<div class="panel-body">
				<div class="col-md-6 col-sm-6 col-xs-12    "  >
				<form action="controller" method="post">
					code compte : <input type="text" name="code"></br> Montant : <input
						type="text" name="montant"></br> <input type="submit"
						value="verser" name="action"> <input type="submit"
						value="retirer" name="action">
				</form>
				</div>
				<div   class="col-md-6 col-sm-6 col-xs-12    "  >
					<form action="controller" method="post">
					code compte1 : <input type="text" name="code1"> </br>
					code compte2 : <input type="text" name="code2"> </br>
					Montant : <input type="text" name="montant"></br>
					 <input type="submit"
						value="virement" name="action"> 
				</form>
				</div>
				<table class="table table-striped">
					<tr>
						<th>Code</th>
						<th>Solde</th>
						<th>Date</th>


					</tr>
					<c:forEach items="${comptes}" var="compte">
						<tr>
							<td>${compte.code}</td>
							<td>${compte.solde}</td>
							<td>${compte.dateCreation}</td>
						</tr>
					</c:forEach>
				</table>

			</div>
		</div>
	</div>



</body>
</html>