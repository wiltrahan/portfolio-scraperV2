<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<title>Date Time Totals</title>
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
 				</tr>
 				
 				<c:forEach var="tempDate" items="${dates}">
 				
 					<tr>
 						<td> ${tempDate.date} </td>
 						<td> ${tempDate.time} </td>
 						<td> ${tempDate.total} </td>
 						<td> ${tempDate.dayGain} </td>
 					</tr>
 						
 				</c:forEach>		
 			
 			</table>
 		
 		</div>
 	
 	</div>
 	
</body>


</html>