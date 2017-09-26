/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let app = angular.module("contactapp", []);

app.controller("ContactController", function ($scope, $http) {
  $scope.token = "";
  $scope.addContact = function () {
    $http({
      method: "POST",
      url: "http://localhost:8080/api/contact",
      data: {
        "firstName": $scope.newContact.firstName,
        "lastName": $scope.newContact.lastName,
        "phoneNumber": $scope.newContact.phoneNumber,
        "email": $scope.newContact.email,
        "id": 0
      },
      headers: {
        "Content-Type": "application/json",
        "authtoken": $scope.token
      }
    }).then(function (response) {
      console.log(response.data);
    }, function (err) {
      console.log(err);
    });
  };

  $scope.deleteAll = function () {
    $http({
      method: "DELETE",
      url: "http://localhost:8080/api/contact",
      headers: {
        "Content-Type": "application/json",
        "authtoken": $scope.token
      }
    }).then(function (data) {
      console.log(data);
    }, function (err) {
      console.log(err);
    });
  };

  $scope.findByLastName = function () {
    let url = "http://localhost:8080/api/contact/" + $scope.lastName;

    $http({
      method: "GET",
      url: url,
      headers: {
        "Content-Type": "application/json",
        "authtoken": $scope.token
      }
    }).then(function (response) {
      console.log(response);
      $scope.contacts = response.data;
    }, function (err) {
      console.log(err);
    });
  };

  $scope.login = function () {
    $http({
      method: "POST",
      url: "http://localhost:8080/login",
      headers: {"Content-Type": "application/json"},
      data: {
        "userName": $scope.userName,
        "password": $scope.password
      }
    }).then(function (response) {
      console.log(response.data);
      $scope.token = response.data.authtoken;
    }, function (err) {
      console.log(err);
    });
  };

  $scope.register = function () {
    $http({
      method: "POST",
      url: "http://localhost:8080/register",
      headers: {"Content-Type": "application/json"},
      data: {
        "userName": $scope.userName,
        "password": $scope.password
      }
    }).then(function (response) {
      console.log(response.data);
    }, function (err) {
      console.log(err);
    });
  };
});
