let countForPosition = 0;
let countForCapteur = 0;
const UPDATE_LIEU = "Lieu à modifier";

$(document).ready(function(){

    const $body = $('body');

    const API_CREATE_LOCATION = '/location/create';
    const API_GET_LOCATION = '/location/find';
    const API_UPDATE_LOCATION = '/location/update';

    const API_POST_POINTXY = '/pointxy/create';
    const API_DELETE_POINTXY = '/pointxy/delete';

    const SITE = $('.user').data('site');

    var locationSelected = undefined;

    $.fn.outerHTML = function(s) {
        return s ? this.before(s).remove(): $("<p>").append(this.eq(0).clone()).html();
    };

    $('.nav-link').on('click', function(){
        let currentPage = $(this);
        let createLocation = $('#create_location');
        let updateLocation = $('#update_location');

        if(!currentPage.hasClass('active')){
            $('.nav-link').removeClass('active');
            currentPage.addClass('active');
        }

        if(createLocation.is(':visible')){
            createLocation.fadeOut(function(){
                updateLocation.fadeIn();
                $.ajax({
                    type: "GET",
                    url: API_GET_LOCATION,
                    data: {
                        locationId: null,
                        siteId: SITE
                    },
                    dataType: 'json',
                    success: function (data) {
                        locationSelected = data.result[0];
                        var html = `<option value="">${UPDATE_LIEU}</option>`;
                        var lenght = data.result[0].length;
                        for ( var i = 0; i < lenght; i++) {
                            html += '<option value="' + locationSelected[i].id + '">'
                                + locationSelected[i].name + '</option>';
                        }
                        html += '</option>';
                        $('#selectLocation').html(html);
                    },
                    error: function (error) {

                    }
                });
            });
        }else{
            updateLocation.fadeOut(function(){
                createLocation.fadeIn();
            });
        }
    });

    // Ajout un point

    $body.on('click', '.addPositionButton', function(){

        let $longitudeUpdate = $('#longitude_update');
        let longitude = $longitudeUpdate.val();


        let $latitudeUpdate = $('#latitude_update');
        let latitude = $latitudeUpdate.val();

        $longitudeUpdate.val('');
        $latitudeUpdate.val('');

        let newPointXY = {};
        newPointXY["locationId"] = locationSelected.id;
        newPointXY["longitude"] =  parseFloat(longitude);
        newPointXY["latitude"] =  parseFloat(latitude);

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: API_POST_POINTXY,
            data: JSON.stringify(newPointXY),
            dataType: 'json',
            success: function (data) {
                locationSelected.pointXYList.push(data.result[0]);
                refreshTablePointXYs();
            },
            error: function (error) {

            }
        });
    });

    $body.on('click', '.removeLocationBtn', function(){
        let currentId = $(this).data('id');
        $.ajax({
            type: "DELETE",
            contentType: "application/json",
            url: API_DELETE_POINTXY,
            data: JSON.stringify(currentId),
            dataType: 'json',
            success: function () {
                locationSelected.pointXYList = locationSelected.pointXYList.filter(function(value, index, arr){
                    return value.id !== currentId;
                });
                refreshTablePointXYs();
            },
            error: function (error) {

            }
        });
    });

    $body.on("click", '.updateLocation', function(){
        let $locationName = $('#locationName');
        let newName = $locationName.val();

        let $locationPersonMax = $('#locationPersonMax');
        let newPersonMax = $locationPersonMax.val();

        let updateLocation = {};
        updateLocation['id'] = locationSelected.id;
        updateLocation['name'] = newName;
        updateLocation['numberPlaces'] = newPersonMax;

        $.ajax({
            type: "PUT",
            contentType: "application/json",
            url: API_UPDATE_LOCATION,
            data: JSON.stringify(updateLocation),
            dataType: 'json',
            success: function (data) {
                locationSelected = data.result[0];
                $('option').each(function(){
                    let id = $(this).attr('value');
                    if(id == locationSelected.id){
                        $(this).text(locationSelected.name);
                    }
                });
                alert(data.msg);
                refreshLocation();
            },
            error: function (error) {

            }
        });
    });

    $('.selectLocation').change(function(){
        locationId = $(this).val();
        if( locationId !== '' ){

            $.ajax({
                type: "GET",
                url: API_GET_LOCATION,
                data: {
                    locationId: locationId,
                    siteId: null
                },
                success: function (data) {
                    locationSelected = data.result[0];

                    refreshLocation();
                    refreshTablePointXYs();
                    $('.update-location-card').fadeIn();
                },
                error: function (error) {

                }
            });

        }else{
            locationSelected = undefined;
            $('.update-location-card').fadeOut();
        }
    });

    $body.on('focus','input', function(){
        $(this).parents('.form-group').addClass('focused');
    });

    $body.on('blur', 'input', function(){
        let inputValue = $(this).val();
        if ( inputValue === "" ) {
            $(this).removeClass('filled');
            $(this).parents('.form-group').removeClass('focused');
        } else {
            $(this).addClass('filled');
        }
    });

    $body.on('click', '.button-append-pointXY', function(){
        countForPosition++;

        let positionContainer = $(this).closest( '.position-container' ),
            currentPositionHTML = $(this).closest( '.position' ).last().outerHTML();

        $(this).remove();

        let newPosition = $(currentPositionHTML);
        newPosition.css('display', 'none');
        newPosition.find('.form-group').removeClass('focused');
        newPosition.removeClass( 'position-' + (countForPosition - 1) ).addClass(`point-${countForPosition}`);

        let inputLongitude = newPosition.find(`[id*='longitude']`).removeClass('filled'),
            forLongitude   = newPosition.find(`[for*='longitude']`);

        let inputLatitude = newPosition.find(`[id*='latitude']`).removeClass('filled'),
            forLatitude   = newPosition.find(`[for*='latitude']`);

        inputLongitude.attr('id', inputLongitude.attr('id') + countForPosition);
        inputLatitude.attr('id', inputLatitude.attr('id') + countForPosition);

        forLongitude.attr('for', forLongitude.attr('for') + countForPosition);
        forLatitude.attr('for', forLatitude.attr('for') + countForPosition);

        positionContainer.append( newPosition );
        newPosition.fadeIn(1000);
    });

    $body.on('click', '.button-append-capteur', function(){
        countForCapteur++;

        let capteurContainer = $(this).closest( '.capteurs-container' ),
            currentCapteurHTML = $(this).closest( '.row' ).last().outerHTML();

        $(this).remove();

        let newCapteur = $(currentCapteurHTML).removeClass( 'capteur-' + (countForCapteur - 1) ).addClass(`capteur-${countForCapteur}`);
        newCapteur.css('display', 'none');
        newCapteur.find('.form-group').removeClass('focused');

        let capteurID    = newCapteur.find(`[id*='capteur-id'`).removeClass('filled'),
            forCapteurID = newCapteur.find(`[for*='capteur-id']`);

        capteurID.attr('id', capteurID.attr('id') + countForCapteur);
        forCapteurID.attr('for', forCapteurID.attr('for') + countForCapteur);

        capteurContainer.append( newCapteur );
        newCapteur.fadeIn(1000);
    });

    $body.on('change', '.mode-test-checkbox' ,function(){
        let checkboxVal = $(this).attr('checked');

        if(checkboxVal){
            $(this).removeAttr('checked');
        }else{
            $(this).attr('checked', 'checked');
        }
    });

    $body.on('click', '.addPlace', function () {
        let locationName = $('#ndl').val();
        let locationPlaceMax = parseInt($('#place-max').val());

        let pointXYArray = [];
        $('div[class*=point]').each(function(){
            let longitude = $(this).find('input').val();
            let latitude = $(this).find('input').last().val();

            if(latitude && longitude) {
                let pointXY = {};
                pointXY['id'] = null;
                pointXY['longitude'] = longitude;
                pointXY['latitude'] = latitude;
                pointXYArray.push(pointXY);
            }
        });

        let sensorArray = [];
        $('div[class*=capteur-]').each(function(){
            let idSensor = $(this).find('input').val();
            if(idSensor) {
                let switchSensor = $(this).find('input').last().attr('checked');
                let sensor = {};
                sensor['id'] =  idSensor;
                sensor['ipConfig'] =  null;
                sensor['isEnabled'] =  true;
                sensor['isInput'] = (switchSensor === undefined);
                sensorArray.push(sensor);
            }
        });

        let location = {};
        location['id'] = null;
        location['name'] = locationName;
        location['urlImage'] = null;
        location['isEnabled'] = true;
        location['numberPlaces'] = locationPlaceMax;
        location['numberUser'] = 0;
        location['pointXYList'] = pointXYArray;
        location['sensorsList'] = sensorArray;

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: API_CREATE_LOCATION,
            data: JSON.stringify(location),
            dataType: 'json',
            success: function (data) {
                newLocation = data.result[0];
                alert(data.msg);
            },
            error: function (error) {

            }
        });

    });

    function refreshTablePointXYs() {
        let $updatePositionCollection = $('#update_position_collection');
        $updatePositionCollection.html("");
        if (locationSelected.pointXYList) {
            for (let i = 0; i < locationSelected.pointXYList.length; i++) {
                let pointXY = locationSelected.pointXYList[i];
                $updatePositionCollection.append(`
                   <tr>
                        <td> ${pointXY.longitude} </td>
                        <td> ${pointXY.latitude} </td>
                        <td>
                            <button data-id="${pointXY.id}" class="btn btn-danger removeLocationBtn">
                                <i class="fa fa-trash remove-position" aria-hidden="true"></i> Supprimer
                            </button>
                        </td>
                    </tr>`);

            }
        }
    }

    function refreshLocation() {
        $('#lieuSelected').text(locationSelected.name);

        let $locationName = $('#locationName');
        $locationName.val(locationSelected.name);
        $locationName.closest('.form-group').addClass('focused');

        let $locationPersonMax = $('#locationPersonMax');
        $locationPersonMax.val(locationSelected.numberPlaces);
        $locationPersonMax.closest('.form-group').addClass('focused');
    }

});