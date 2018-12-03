<%@ taglib uri="struts/bean-el" prefix="bean" %>
<%@ taglib uri="struts/html-el" prefix="html" %>
<%@ taglib uri="struts/logic-el" prefix="logic" %>
<%@ taglib uri="jstl/c" prefix="c" %>
<html>
<head>
<title><bean:message key="olns.title" /></title>
<link rel="stylesheet" href="/eMegaMart-Application/css/mystyle.css" type="text/css" />
</head>
<body>
<table align="center" width="900">
<tr>
	<td colspan="2"><jsp:include page = "../jsp/olns_header.jsp" /></td>
</tr>
<tr>
<td width="150" bgcolor="#86AEDF">
	<jsp:include page = "../jsp/olns_main_menu.jsp"/>
</td>
<td width="750" valign=top>
	<html:errors /><br>
	<div class=violethead align=center>
	Your Order Detail</div>
	<hr width=300>
	<table border="0" cellspacing="0" cellpadding="2" align="center" bgcolor="#AE62AC" class=yellowtext width=400>
	<tr>
		<td colspan="2" align="center" class=boldwhite>Delivery Address Details<hr></td>
	</tr>
	<tr >
		<td>Contact Name</td>
		<td ><bean:write name="order" property="contact_name" /></td>
	</tr>
	<tr >
		<td >Delivery Address</td>
		<td ><bean:write name="order" property="delivery_address" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center" class=boldwhite>Credit Card Details<hr></td>
	</tr>
	<tr >
		<td >Credit Card Name</td>
		<td ><bean:write name="order" property="cc_name" /></td>
	</tr>
	<tr >
		<td >Credit Card Number</td>
		<td ><bean:write name="order" property="cc_number" /></td>
	</tr>
	<tr >
		<td >Credit Card Expiry Date</td>
		<td ><bean:write name="order" property="cc_expiry_date" /></td>
	</tr>
	</table>
<br>
	<table border="0" cellspacing="0" cellpadding="2" align="center" bgcolor="#AE62AC" class=yellowtext width=400>
	<tr>
	<td colspan="3" align="center" class=boldwhite>Order Details<hr></td>
	</tr>
	<tr align=center class=boldwhite>
	<td >Product Id</td>
	<td >Quantity</td>
	<td >SubTotal</td>
	</tr>
	<!-- iterate over the results of the query -->
	<logic:iterate id="lOrderDtl" name="lOrderDtlArr">
	<tr align=center >
	<td ><bean:write name="lOrderDtl" property="product_id" /></td>
	<td ><bean:write name="lOrderDtl" property="order_qty" /></td>
	<td ><bean:write name="lOrderDtl" property="order_price" /></td>
	</tr>
	</logic:iterate>
	</table>
</td>
</tr>
<tr>
<td colspan=2><%@ include file="../jsp/olns_footer.jsp" %></td>
</tr>
</table>
</body>
</html>