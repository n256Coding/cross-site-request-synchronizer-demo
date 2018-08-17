$.post('/csrf', {}, function (data, status) {
    const csrf_token = data;
    $('<input>').attr({
        type: 'hidden',
        id: 'X-CSRFToken',
        name: 'csrf_token',
        value: data.csrf
    }).appendTo('form');
});

$('#my_data_form').submit(function (event) {
    event.preventDefault();
    var formData = {};
    formData.receiver_account_number = $('#receiver_account_number').val();
    formData.value = $('#value').val();
    formData.csrf_token = $('#X-CSRFToken').val();


    $.ajax({
        type : "POST",
        url : "/mydata",
        data : $(this).serialize(),
        success : function (data, status) {
            if(status == "success") {
                if (data.response == "success") {
                    $("#form_response").html('Data transfer is successful');
                }
                else if (data.response == "forbidden") {
                    $("#form_response").html('Request forbidden. Transferring process cancelled.');
                }
            }
            else{
                $("#form_response").html('Unknown error occurred. Try again');
            }
            $('#informationModel').modal('show');
        }
    });

    // $.post('/mydata', {
    //     'car_brand':$('#car_brand').val(),
    //     'drink' : $('#drink').val(),
    //     'tv_show' : $('#tv_show').val(),
    //     'csrf_token' : $('#X-CSRFToken').val()
    // }, function (data, status) {
    //     console.log("Inside post");
    //     if(status == "success") {
    //         if (data.response == "success") {
    //             $("#form_response").html('Data has successfully recorded.');
    //         }
    //         else if (data.response == "invalid") {
    //             $("#form_response").html('Request forbidden. Nothing recorded.');
    //         }
    //     }
    //     else{
    //         $("#form_response").html('Unknown error occurred. Try again');
    //     }
    //     $('#informationModel').modal('show');
    // });
});