angular.module("emegaMart")
       .constant("hostURL", document.location.protocol+"//"+document.location.host)
       .controller("loginController", function($scope,$http,$location,hostURL) {
       	
    	   $scope.data={};
    	   
    	   $scope.login=function(data){
    		   var userLogin=angular.copy(data);
    		   $http.post(hostURL+"/login",userLogin).success(function(data) {
   	   				$scope.data=data;
   	   			}).error(function(error) {
   	   				$scope.data.error=error;
   	   			});
    		    
    		   
    	   }
       });