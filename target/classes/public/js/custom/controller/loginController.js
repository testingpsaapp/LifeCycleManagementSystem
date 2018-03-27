/**
 * Login Controller
 */

lcms.controller('loginController', function($rootScope,$scope,$http,$location) {
	$scope.user="Guest";	
	$scope.loginUser=[];
	$scope.password="";
	$scope.message=false;
	$scope.loginMessage="";
	
	$scope.gctRegTab=true;
	$scope.businessRegTab=false;
	
	$scope.failureMessageModel=false;
	$scope.successMessageModel=false;
	
	$scope.saveMessage=[];
	
	$scope.countries =[];
	
	$scope.applications=[];
	
	$scope.getCountry = function()
	{
		$http.get('/countries/'+$scope.reg_b_region).then(function(data){
            $scope.countries = data.data;
		});
	};
	
	$scope.getApplications = function()
	{
		$http.get('/appConfig/'+$scope.lob).then(function(data){
            $scope.applications = data.data;
		});
	};
	
	$scope.showGCT =function()
	{
		$scope.gctRegTab=true;
		$scope.businessRegTab=false;
		$scope.failureMessageModel=false;
		$scope.successMessageModel=false;
	};
	
	$scope.showBusiness =function()
	{
		//alert('hello');
		$scope.gctRegTab=false;
		$scope.businessRegTab=true;
		$scope.failureMessageModel=false;
		$scope.successMessageModel=false;
	};
	
	$scope.login =function()
	{
		if($scope.user==undefined || $scope.user==null || $scope.user=="" || $scope.user=="Guest")
		{
			//alert("Enter SOE ID");
			$scope.loginMessage="Enter SOE ID";
			$scope.message=true;
			
		}
		else if ($scope.password==undefined || $scope.password==null || $scope.password=="")
		{
			$scope.loginMessage="Enter Password";
			$scope.message=true;	
		}
		else
		{
			$scope.loginUser =
			 {
				 "soeId" : $scope.user,
				 "password" : $scope.password
			 };
			$http.post('/loginAuthenticate', $scope.loginUser)
			.then(function(data){
			 if(JSON.parse(data.data[0]).status == 'User Not Registered')
			 {
				 $scope.loginMessage="User Not Registered";
				 $scope.message=true;
			 }
			 else if(JSON.parse(data.data[0]).status == 'Incorrect Credential')
			 {
				 $scope.loginMessage="Incorrect Credential";
				 $scope.message=true;
			 }
			 else
			 {
				 if(typeof(Storage) !== "undefined") 
				 {
				        localStorage.currentUser = data.data[1].soeId; 
				        localStorage.currentUserFirstName = data.data[1].firstName;
				        localStorage.currentUserMenu=JSON.parse(data.data[2]).menu;
				        localStorage.sessionId=data.data[1].uuid;
				        //console.log(JSON.parse(data.data[2]).menu);
				        $location.path( "/home" );
				 } 
				 else 
				 {
					 alert("Browser Not Supported. Please Use Chrome.");
				 }	
			 }
		 } ,
		 function(data){
			 
			 
		 });
		}
		
	};
	
	$scope.register = function()
	{
		
		
		if($scope.businessRegTab)
		{
			if($scope.reg_b_soe_id == '' || $scope.reg_b_soe_id == undefined)
			{
				$scope.saveMessage.message="Please Enter SOE ID";
				$scope.failureMessageModel=true;
			}
			else if($scope.reg_b_first_name=='' || $scope.reg_b_first_name == undefined)
			{
				$scope.saveMessage.message="Please Enter First Name";
				$scope.failureMessageModel=true;
			}
			else if($scope.reg_b_last_name=='' || $scope.reg_b_last_name == undefined)
			{
				$scope.saveMessage.message="Please Enter Last Name";
				$scope.failureMessageModel=true;
			}
			else if($scope.reg_b_region=='' || $scope.reg_b_region == undefined)
			{
				$scope.saveMessage.message="Please Select Region";
				$scope.failureMessageModel=true;
			}
			else if($scope.reg_b_country=='' || $scope.reg_b_country == undefined)
			{
				$scope.saveMessage.message="Please Select Country";
				$scope.failureMessageModel=true;
			}
			else if($scope.reg_b_department=='' || $scope.reg_b_department == undefined)
			{
				$scope.saveMessage.message="Please Enter Department";
				$scope.failureMessageModel=true;
			}
			else if($scope.reg_b_password=='' || $scope.reg_b_password == undefined)
			{
				$scope.saveMessage.message="Please Enter Password";
				$scope.failureMessageModel=true;
			}
			else if($scope.reg_b_confirm_password=='' || $scope.reg_b_confirm_password == undefined)
			{
				$scope.saveMessage.message="Please Enter Confirm Password";
				$scope.failureMessageModel=true;
			}
			else if($scope.reg_b_password!=$scope.reg_b_confirm_password)
			{
				$scope.saveMessage.message="Password And Confirm Password Do Not Match";
				$scope.failureMessageModel=true;
			}
			else
			{
				$("body").addClass("loading");
				$scope.user={
					'soeId':$scope.reg_b_soe_id,
					'firstName':$scope.reg_b_first_name,
					'lastName':$scope.reg_b_last_name,
					'region':$scope.reg_b_region,
					'country':$scope.reg_b_country,
					'department':$scope.reg_b_department,
					'password':$scope.reg_b_password,
					'confirmPassword':$scope.reg_b_confirm_password,
					'userType':'business'
				};
				//console.log($scope.user);
				$http.post('/register', $scope.user)
				 .then(function(data){
					 console.log(data);
					 //console.log(data.status);
					 //loginService.user=$scope.reg_soe_id;
					 if(data.data['message'] == 'User Already Exists.'){
						 //window.location.href = "/index.html";
						 $scope.saveMessage.message=data.data['message'];
						 $scope.failureMessageModel=true;
						 $scope.successMessageModel=false;
						 
					 }
					 else if(data.data['message'] == 'Registration Failed')
					 {
						 $scope.saveMessage.message=data.data['message'];
						 $scope.failureMessageModel=true;
						 $scope.successMessageModel=false;
						 
					 }
					 else if(data.data['message'] == 'Registration Successful. Please Login To Proceed.')
					 {
						 $scope.saveMessage.message=data.data['message'];
						 $scope.successMessageModel=true; 
						 $scope.failureMessageModel=false;
						 
					 }
					 
				 },function(data){
					 $scope.saveMessage.message=data.data;
					 $scope.failureMessageModel=true;
					 
				 });
				
				$("body").removeClass("loading");
			}
		}
		else if($scope.gctRegTab)
		{
			if($scope.reg_soe_id == '' || $scope.reg_soe_id == undefined)
			{
				$scope.saveMessage.message="Please Enter SOE ID";
				$scope.failureMessageModel=true;
			}
			else if($scope.first_name=='' || $scope.first_name == undefined)
			{
				$scope.saveMessage.message="Please Enter First Name";
				$scope.failureMessageModel=true;
			}
			else if($scope.last_name=='' || $scope.last_name == undefined)
			{
				$scope.saveMessage.message="Please Enter Last Name";
				$scope.failureMessageModel=true;
			}
			else if($scope.region=='' || $scope.region == undefined)
			{
				$scope.saveMessage.message="Please Select Region";
				$scope.failureMessageModel=true;
			}
			else if($scope.lob=='' || $scope.lob == undefined)
			{
				$scope.saveMessage.message="Please Select LOB";
				$scope.failureMessageModel=true;
			}
			else if($scope.application=='' || $scope.application == undefined)
			{
				$scope.saveMessage.message="Please Select Applications";
				$scope.failureMessageModel=true;
			}
			else if($scope.reg_password=='' || $scope.reg_password == undefined)
			{
				$scope.saveMessage.message="Please Enter Password";
				$scope.failureMessageModel=true;
			}
			else if($scope.reg_confirm_password=='' || $scope.reg_confirm_password == undefined)
			{
				$scope.saveMessage.message="Please Enter Confirm Password";
				$scope.failureMessageModel=true;
			}
			else if($scope.reg_password!=$scope.reg_confirm_password)
			{
				$scope.saveMessage.message="Password And Confirm Password Do Not Match";
				$scope.failureMessageModel=true;
			}
			else
			{
				$("body").addClass("loading");
				$scope.user={
					'soeId':$scope.reg_soe_id,
					'firstName':$scope.first_name,
					'lastName':$scope.last_name,
					'region':$scope.region,
					'lob':$scope.lob,
					'applications':$scope.application,
					'password':$scope.reg_password,
					'confirmPassword':$scope.reg_confirm_password,
					'userType':'gct'
				};
				//console.log($scope.user);
				$http.post('/register', $scope.user)
				 .then(function(data){
					 console.log(data);
					 //console.log(data.status);
					 //loginService.user=$scope.reg_soe_id;
					 if(data.data['message'] == 'User Already Exists.'){
						 //window.location.href = "/index.html";
						 $scope.saveMessage.message=data.data['message'];
						 $scope.failureMessageModel=true;
						 $scope.successMessageModel=false;
						 
					 }
					 else if(data.data['message'] == 'Registration Failed')
					 {
						 $scope.saveMessage.message=data.data['message'];
						 $scope.failureMessageModel=true;
						 $scope.successMessageModel=false;
						 
					 }
					 else if(data.data['message'] == 'Registration Successful. Please Login To Proceed.')
					 {
						 $scope.saveMessage.message=data.data['message'];
						 $scope.successMessageModel=true; 
						 $scope.failureMessageModel=false;
						 
					 }
					 
				 },function(data){
					 $scope.saveMessage.message=data.data;
					 $scope.failureMessageModel=true;
					 
				 });
				
				$("body").removeClass("loading");
			}
		}
	};
}).config(['$routeProvider',function($routeProvider){
	$routeProvider.
	when("/home",{
		templateUrl:"/home.html",
		controller:	"homeController"
	})
}]);