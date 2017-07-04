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

        case 'Admin Panel':
            $('#admin').addClass('active');
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
        console.log(jsonURL)
        $table.DataTable({

           lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','All']],
            pageLength:5,
            ajax:{

                url:jsonURL,
                dataSrc:''
            },
            columns:[
                {
                    data:'image',//the key of json data must be the name of data
                    bSortable:false,
                    mRender:function(data,type,row){
                        return '<img src=' + window.siteURL+ data+' width="180" height="172"/>'; //displaying image in first column
                        '<img src='+window.siteURL+data+' width="180" height="172"/>'
                    }
                },
                {
                    data:'pname'
                },
                {
                    data:'price',
                    mRender:function(data,type,row){
                        return '&#8360; '+ data //8360 is the html code for Rs.Symbol
                    }
                },
                {
                    data:'quantity'
                },
                {
                    data:'pid',
                    bSortable:false,
                    mRender:function(data,type,row){
                        var str='';
                        str+= '<a href="'+window.siteURL+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> ';
                        str+= '<a href="'+window.siteURL+'/show/'+data+'/product" class="btn btn-danger"><span class="glyphicon glyphicon-shopping-cart"></span></a> ';
                        return str;
                    }
                }
            ]
        });

    }
});