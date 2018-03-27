/**
 * Main Controller
 */

lcms.controller('lifeCycleManagementSystemController', function($rootScope,$scope,$http) {
	
	
})
.config(['$routeProvider',function($routeProvider){
		$routeProvider.
			when("/",{
				templateUrl:"/login.html",
				controller:	"loginController"
			})
}]);