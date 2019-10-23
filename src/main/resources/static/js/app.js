var app = (function () {

    var map;

    var getAirports = function (locationName) {
        var getPromise = $.get("/Airports/"+locationName);

        getPromise.then(
            function (data,status){
                $("#listAirports tbody").empty();
                JSON.parse(data).map(function (value, index) {
                    var toAdd = '<tr><td>'+value.code+'</td><td>'+value.name+'</td><td>'+value.city+'</td><td>'+value.countryCode+'</td></tr>'
                    $("#listAirports tbody").append(toAdd);
                });
                console.log(data);
            },
            function () {
                console.log("Bad request");
            }
        );
        return getPromise;


    };


    return {

        searchAirports: function(){
            var locationName =  document.getElementById("locationInput").value;

            getAirports(locationName);

        },

        init : function(){
            /*map = new google.maps.Map(document.getElementById('map'), {
                center: {lat: -34.397, lng: 150.644},
                zoom: 8
            });*/


        }


    };

})();