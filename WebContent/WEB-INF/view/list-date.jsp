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
 					<th>Date</th>
 					<th>Time</th>
 					<th>Total</th>
 					<th>Day Gain/Loss</th>
 					<th>More Info</th>
 				</tr>
 				
 				<c:forEach var="tempDate" items="${dates}">
 					<c:url var="portfolio" value="/date/portfolio">
 						<c:param name="dateId" value="${tempDate.id}"/>
 				
 					</c:url>
 				
 				
 					<tr>
 						<td> ${tempDate.date} </td>
 						<td> ${tempDate.time} </td>
 						<td> ${tempDate.total} </td>
 						<td> ${tempDate.dayGain} </td>
 						<td><a href="${portfolio}"><button type="button" class="btn btn-outline-primary btn-block">More Info</button></a></td>
 					</tr>
 						
 				</c:forEach>		
 			
 			</table>
 		
 		</div>
 	
 	</div>
 	
</body>


</html>