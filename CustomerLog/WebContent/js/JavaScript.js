
		function validate()
		{
			var fName=document.form1.fName.value;
			var lName=document.form1.lName.value;
			var mobile=document.form1.mobile.value;
			var telephone=document.form1.telephone.value;
			var dob=document.form1.dob.value;
			var gender=document.form1.gender.value;
			var uID=document.form1.uID.value;
			var filename=document.form1.filename.value;
			var passwrd=document.form1.passwrd.value;
			var passwrd2=document.form1.passwrd2.value;
			var Praddress=document.form1.Praddress.value;
			var Prpin=document.form1.Prpin.value;
			var Peraddress=document.form1.Peraddress.value;
			var Ppin=document.form1.Ppin.value;
			var Oaddress=document.form1.Oaddress.value;
			var Opin=document.form1.Opin.value;
			var company=document.form1.company.value;
			var designation=document.form1.designation.value;
			var country=document.form1.country.value;
			var state=document.form1.state.value;
			var city=document.form1.city.value;
			
			if(fName==""||fName==null)
			{
				alert("Please Enter Your First Name"); 
				
				document.form1.fName.focus();
				return false;
				
			}
			
			if(lName==""||lName==null)
			{
				alert("Please Enter Your Last Name"); 
				document.form1.lName.focus();
				return false;
			}
			
			if(mobile==""||mobile==null)
			{
				alert("Please Enter Your Mobile Number"); 
				document.form1.mobile.focus();
				return false;
			}
			else{
				if(isNaN(mobile)){
					alert("Please enter digit");
					document.form1.mobile.focus();
					return false;
				}
				
			}
			
			if(telephone==""||telephone==null)
			{
				alert("Please Enter Your Telephone Number"); 
				document.form1.telephone.focus();
				return false;
			}
			else{
				if(isNaN(telephone)){
					alert("Please enter digit");
					document.form1.telephone.focus();
					return false;
				}
			}
			
			if(dob==""||dob==null)
			{
				alert("Please Enter Your DOB"); 
				document.form1.dob.focus();
				return false;
			}
			
			
			if(gender==""||gender==null)
			{
				alert("Please Select Your Gender"); 
				document.form1.telephone.focus();
				return false;
			}
			
			if (uID==""|| uID==null){  
				  alert("Please enter a valid e-mail address");  
				  return false;  
			} 
			
			if(filename==""||filename==null)
			{
				alert("Please Upload Your Image"); 
				document.form1.filename.focus();
				return false;
			}
			
			if(passwrd==""||passwrd==null)
			{
				alert("Please Enter Your Password"); 
				document.form1.passwrd.focus();
				return false;
			}else{
				if(passwrd2==""||passwrd2==null)
				{
					alert("Please Confirm Your Password"); 
					document.form1.passwrd2.focus();
					return false;
				}
				
				
			} 
			if(passwrd!=passwrd2){
				alert("Password must be same!");
				return false;
			}
			
			
			if (Praddress=="" || Praddress==null){  
				  alert("Present Address can't be blank");  
				  document.form1.Praddress.focus();
					return false;
				}
			
			if(Prpin==""||Prpin==null)
			{
				alert("Please Enter Present address pin code"); 
				document.form1.Prpin.focus();
				return false;
			}
			else{
				if(isNaN(Prpin)){
					alert("Please enter digit");
					document.form1.Prpin.focus();
					return false;
				}
			}
			
			if(Peraddress==""|| Peraddress==null){
				alert("Please Enter Your Permanent address"); 
				document.form1.Peraddress.focus();
				return false;
			}
			
			if(Ppin==""||Ppin==null)
			{
				alert("Please Enter Permanent address pin code"); 
				document.form1.Ppin.focus();
				return false;
			}
			else{
				if(isNaN(Ppin)){
					alert("Please enter digit");
					document.form1.Ppin.focus();
					return false;
				}
			}
			if(Oaddress==""||Oaddress==null)
			{
				alert("Please Enter Your Office address"); 
				document.form1.Oaddress.focus();
				return false;
			}
			
			if(Opin==""||Opin==null)
			{
				alert("Please Enter Office address pin code"); 
				document.form1.Opin.focus();
				return false;
			}
			else{
				if(isNaN(Opin)){
					alert("Please enter digit");
					document.form1.Opin.focus();
					return false;
				}
			}
			
			if(company==""||company==null){
				alert("Please Enter Your Company Name!");
				document.form1.company.focus();
				return false;
			}
			
			if(designation==""||designation==null){
				alert("Please Enter Your designation!");
				document.form1.designation.focus();
				return false;
			}
			
			if(country==""||country==null){
				alert("Please Select Your country!");
				document.form1.country.focus();
				return false;
			}
			
			if(state==""||state==null){
				alert("Please Select Your state!");
				document.form1.state.focus();
				return false;
			}
			
			if(city==""||city==null){
				alert("Please Select Your city!");
				document.form1.city.focus();
				return false;
			}
			
			return true;
		}
				
