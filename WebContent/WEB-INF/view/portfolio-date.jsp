<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	
	<title>Date Time Totals</title>
	
	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>
		
</head>
<body>

 	<div id="wrapper">
 		<div id="header">
 			<h2>We-B-Scraping!</h2>
 		
 		</div>
 	</div>
 	<div id="container">
 		<div id="content">
 		
 			<table>
 				
 				<tr>
 					<th>Symbol</th>
 					<th>Value</th>
 					<th>Daily Amount Change</th>
 					<th>Daily Percentage Change</th>
 					<th>Total Shares</th>
 				</tr>
 				
 				<c:forEach var="tempStock" items="${stocks}">
 				
 					<tr>
 						<td> ${tempStock.symbol} </td>
 						<td> ${tempStock.value} </td>
 						<td> ${tempStock.dayAmtChg} </td>
 						<td> ${tempStock.dayPctChg} </td>
 						<td> ${tempStock.totalShrs} </td>
 					</tr>
 						
 				</c:forEach>		
 			
 			</table>
 		
 		</div>
 	
 	</div>
 	
</body>


</html>