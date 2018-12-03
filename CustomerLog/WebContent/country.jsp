<%@page import="java.sql.*"%>
 <html>
      <head>  
      <script language="javascript" type="text/javascript">  
      var xmlHttp  
      var xmlHttp
      function showState(str){
      if (typeof XMLHttpRequest != "undefined"){
      xmlHttp= new XMLHttpRequest();
      }
      else if (window.ActiveXObject){
      xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
      }
      if (xmlHttp==null){
      alert("Browser does not support XMLHTTP Request")
      return;
      } 
      var url="state.jsp";
      url +="?count=" +str;
      xmlHttp.onreadystatechange = stateChange;+
      xmlHttp.open("GET", url, true);
      xmlHttp.send(null);
      }

      function stateChange(){   
      if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
      document.getElementById("state").innerHTML=xmlHttp.responseText   
      }   
      }

      function showCity(str){
      if (typeof XMLHttpRequest != "undefined"){
        xmlHttp= new XMLHttpRequest();
        }
      else if (window.ActiveXObject){
        xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
        }
      if (xmlHttp==null){
      alert("Browser does not support XMLHTTP Request")
      return;
      } 
      var url="city.jsp";
      url +="?count=" +str;
      xmlHttp.onreadystatechange = stateChange1;
      xmlHttp.open("GET", url, true);
      xmlHttp.send(null);
      }
      function stateChange1(){   
      if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
      document.getElementById("city").innerHTML=xmlHttp.responseText   
      }   
      }
      </script>  
      </head>  
      <body>  
      <table border="1">
      <tr><th>Country</th><th>State</th><th>City</th></tr>
      <tr><td>
      <select name='country' onchange="showState(this.value)">  
       <option value="none">Select</option>  
    <%
		 Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();  
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","chaman_bharti","@chaman#2012");  
		 Statement stmt = con.createStatement();  
		 ResultSet rs = stmt.executeQuery("Select * from country");
		 while(rs.next()){
		     %>
		      <option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>  
		      <%
		 }
     %>
      </select> 
      </td>
      <td id='state'><select name='state' >  
      <option value='-1'></option>  
      </select>
      </td>
       <td id='city'> <select name='city' >  
      <option value='-1'></option>  
      </select>   
      </td>
      </tr>
      </table>
      </body> 
      </html>