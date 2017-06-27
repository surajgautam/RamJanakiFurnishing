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

        case 'Home':
            $('#home').addClass('active');
            break;

        case 'Login':
            $('#login').addClass('active');
            break;

        case 'All Products':
            $('#products').addClass('active');
            break;

        default:
            $('#home').addClass('active');
            break;

    }

    //code for jquery data table

    var $table = $('#productListTable');
    if($table.length){

        var jsonURL = '';
        if(window.categoryID == ''){
            jsonURL = window.siteURL + '/get/all/products';
        }
        else{
            jsonURL=window.siteURL+'/get/category/'+window.categoryID+'/products';
        }

        $table.DataTable({
           lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','All']],
            pageLength:5,
            ajax:{
                url:jsonURL,
                dataSrc:''
            },
            columns:[
                {
                    data:'cname'
                },
                {
                    data:'cname'
                },
                {
                    data:'cname'
                },
            ]
        });

    }




});