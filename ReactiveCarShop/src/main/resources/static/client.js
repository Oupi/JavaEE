let app = angular.module("CarApp", []);

app.controller("CarController", function ($scope, $http) {
    $scope.streamOn = false;
    $scope.carStream = [];

    $scope.getCars = function () {
        $http({
            "method": "GET",
            "url": "/api/car",
            "headers": { "Content-Type": "application/json" }
        }).then(function (data) {
            console.log(data.data);
            $scope.carList = data.data;
        }, function (error) {
            console.log(error);
        });
    }

    $scope.addCar = function () {
        $http({
            "method": "POST",
            "url": "/api/car",
            "headers": { "Content-Type": "application/json" },
            "data": {
                "type": $scope.type,
                "price": $scope.price,
                "year": $scope.year
            }
        }).then(function (data) {
            console.log(data.data);
            $scope.getCars();
        }, function (error) {
            console.log(error);
        });
    }

    $scope.streamCars = function () {
        $scope.streamOn = true;        
        if (typeof (EventSource) !== "undefined") {
            let source;
            source = new EventSource("/api/car/stream");
            source.onopen = function (event) {
                console.log("Source open");
            }
            source.onmessage = function (event) {
                console.log(event);
                if (!$scope.streamOn) {
                    source.close();
                }
                $scope.carStream.push(JSON.parse(event.data));
            };
        } else {
            $scope.carStream = "Not supported";
        }
    };

    $scope.stopStream = function(){
        $scope.streamOn = false;
    };
});