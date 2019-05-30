var appCliente = angular.module("appCliente",[]);

appCliente.controller("indexController",function($scope,$http){

$scope.clientes=[];
$scope.clientes={};

$scope.carregarClientes= function(){
$http({
  method: 'GET',
  url: 'http://localhost:8080/clientes'
}).then(function(response) {
    $scope.clientes=response.data;
	console.log(response.status)
  }, function (response) {
    $scope.clientes=response.data;
	console.log(response.status)
  });
};

$scope.salvarClientes= function(){
$http({
  method: 'POST',
  url: 'http://localhost:8080/clientes',
  data:	cliente
}).then(function(response) {
    $scope.clientes=response.data;
	console.log(response.status)
  }, function (response) {
    $scope.clientes=response.data;
	console.log(response.status)
  });
};

$scope.carregarClientes();
$scope.salvarClientes();	 












});

