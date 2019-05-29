var appCliente = angular.module("appCliente",[]);

appCliente.controller("indexController",function($scope,$http){
$scope.nome="Jao";
$scope.sobrenome="Silva";
$scope.clientes=[];

$http({method:'GET', url:'http:localhost:8080/clientes'})
.then(function(response){
	$scope.clientes=[response.data];
	console.log(response.status)
},function(response){
	console.log(response.data)
	console.log(response.status)
})
});