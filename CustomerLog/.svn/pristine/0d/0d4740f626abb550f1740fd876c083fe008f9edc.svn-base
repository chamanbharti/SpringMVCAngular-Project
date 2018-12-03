var xmlHttp;

function showCountry(){
	
	  // For Mozilla/Safari Or Chrome
	  if (typeof XMLHttpRequest != "undefined"){
		  xmlHttp= new XMLHttpRequest();
	  }
	  // IE
	  else if (window.ActiveXObject){
		  xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  if (xmlHttp==null){
		  alert("Browser does not support XMLHTTP Request")
		  return;
	  } 
	  
	  var url="CountryHandler";
	  
	  xmlHttp.open("GET", url, true);
	  xmlHttp.send(null);
	  
	  xmlHttp.onreadystatechange = function() {
		  if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
			  var countryList=xmlHttp.responseText;
			  document.getElementById("country").innerHTML=countryList;   
		  } 
	  }
}

function showState(countryId){
	
	  // For Mozilla/Safari Or Chrome
	  if (typeof XMLHttpRequest != "undefined"){
		  xmlHttp= new XMLHttpRequest();
	  }
	  // IE
	  else if (window.ActiveXObject){
		  xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  if (xmlHttp==null){
		  alert("Browser does not support XMLHTTP Request")
		  return;
	  } 
	  
	  var url="StateHandler?counrtyId="+countryId.value;
	  
	  xmlHttp.open("GET", url, true);
	  xmlHttp.send(null);
	  
	  xmlHttp.onreadystatechange = function() {
		  if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
			  var stateList=xmlHttp.responseText;
			  document.getElementById("state").innerHTML=stateList;   
		  } 
	  }
}

function showCity(cityId){
	
	  // For Mozilla/Safari Or Chrome
	  if (typeof XMLHttpRequest != "undefined"){
		  xmlHttp= new XMLHttpRequest();
	  }
	  // IE
	  else if (window.ActiveXObject){
		  xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  if (xmlHttp==null){
		  alert("Browser does not support XMLHTTP Request")
		  return;
	  } 
	  
	  var url="CityHandler?cityId="+cityId.value;
	  
	  xmlHttp.open("GET", url, true);
	  xmlHttp.send(null);
	  
	  xmlHttp.onreadystatechange = function() {
		  if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
			  var stateList=xmlHttp.responseText;
			  document.getElementById("city").innerHTML=stateList;   
		  } 
	  }
}