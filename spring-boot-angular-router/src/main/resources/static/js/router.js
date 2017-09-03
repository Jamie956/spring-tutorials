var app = angular.module('app', ['ui.router']);

app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
	$stateProvider
	.state('transactions', {
		url: '/transactions?tabs',
		templateUrl: '../transactions.html',
		controller: 'transactionsController'
	})
	.state('root', {
		url: '/',
		template: '<strong>Oh yeah, You coming home...</strong>'
	})
	.state('otherwise',{
		url: "*path",
		template: '<strong>Oh no, you out of this world...</strong'
	});
	$urlRouterProvider.otherwise('/');
}]);