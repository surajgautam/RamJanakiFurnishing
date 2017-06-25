/**
 * Created by surajgautam on 6/24/17.
 */
$(function(){


    switch(menu){

        case 'About Us':
            $('#aboutus').addClass('active');
            break;

        case 'Contact':
            $('#contact').addClass('active');
            break;

        default:
            $('#home').addClass('active');
            break;

    }



});