/**
 * Home Page Controller
 */
lcms.controller('homeController', function($rootScope,$scope,$http,$location) {
	$scope.loggedInUser = localStorage.currentUser;
	$scope.loggedInUserFirstName= localStorage.currentUserFirstName;
	//$scope.noAccess=false;
	//$scope.access=false;
	$scope.menu =[];
	$scope.userMenu = [];
	if(localStorage.currentUserMenu=='none')
	{
		$scope.menu.selected='noAccess';
	}
	else
	{
		$scope.menu.selected='worklist';
		$scope.userMenu = localStorage.userMenu;
		console.log(localStorage.userMenu);
	}
	
	$scope.routeMenu=function(x){
		$scope.menu.selected=x;
	};
})