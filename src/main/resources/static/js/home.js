let countForPosition = 0;
let countForCapteur = 0;
const UPDATE_LIEU = "Lieu à modifier";

$(document).ready(function(){

    const $body = $('body');

    var placeSelected = undefined;

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
            });
        }else{
            updateLocation.fadeOut(function(){
                createLocation.fadeIn();
            });
        }
    });

    // Ajout une position.

    $body.on('click', '#appendPositionUpdateButton', function(){

        let $longitudeUpdate = $('#longitude_update');
        let longitude = $longitudeUpdate.val();


        let $latitudeUpdate = $('#latitude_update');
        let latitude = $latitudeUpdate.val();

        $longitudeUpdate.val('');
        $latitudeUpdate.val('');

        $('.longitude-form').removeClass('focused');
        $('.latitude-form').removeClass('focused');

        $('#update_position_collection').append(`
                                <tr>
                                    <td> ${ longitude } </td>
                                    <td> ${ latitude } </td>
                                    <td>
                                            <button class="btn btn-danger removeLocationBtn"> 
                                                    <i class="fa fa-trash remove-position" aria-hidden="true"></i> Supprimer
                                            </button>
                                    </td>
                                </tr>`);
    });

    $body.on('click', '.removeLocationBtn' ,  function(){
        $(this).closest('tr').fadeOut();
    });

    $('#selectLocation').change(function(){
        currentLocation = $(this).val();
        if( currentLocation !== '' ){
            placeSelected = JSON.parse(currentLocation);
            console.log(placeSelected);
            $('#lieuSelected').text(placeSelected.name);
            let $locationName = $('#locationName');
            $locationName.val(placeSelected.name);
            $locationName.closest('.form-group').addClass('focused');

            let $locationPersonMax = $('#locationPersonMax');
            $locationPersonMax.val(placeSelected.numberPlaces);
            $locationPersonMax.closest('.form-group').addClass('focused');

            $('.update-location-card').fadeIn();

        }else{
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

    $body.on('click', '#appendPositionButton', function(){

    });

    $body.on('click', '#appendPositionButton', function(){
        countForPosition++;

        let positionContainer = $(this).closest( '.position-container' ),
            currentPositionHTML = $(this).closest( '.position' ).last().outerHTML();

        $(this).remove();

        let newPosition = $(currentPositionHTML);
        newPosition.css('display', 'none');
        newPosition.find('.form-group').removeClass('focused');

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

    $body.on('click', '#appendCapteurButton', function(){
        countForCapteur++;

        let capteurContainer = $(this).closest( '.capteurs-container' ),
            currentCapteurHTML = $(this).closest( '.row' ).last().outerHTML();

        $(this).remove();

        let newCapteur = $(currentCapteurHTML);
        newCapteur.css('display', 'none');
        newCapteur.find('.form-group').removeClass('focused');

        let capteurID    = newCapteur.find(`[id*='capteur-id'`).removeClass('filled'),
            forCapteurID = newCapteur.find(`[for*='capteur-id']`);

        capteurID.attr('id', capteurID.attr('id') + countForCapteur);
        forCapteurID.attr('for', forCapteurID.attr('for') + countForCapteur);

        capteurContainer.append( newCapteur );
        newCapteur.fadeIn(1000);
    });
});