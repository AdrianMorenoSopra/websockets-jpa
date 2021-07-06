var stompClient = null;
var user = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
        user = $("#name").val();
    }
    else {
        $("#conversation").hide();
        user = null;
    }

    // $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/thedfa-communicationshub');
    stompClient = Stomp.over(socket);
    stompClient.connect($('#name').val(), $('#name').val(), function (frame) {
                                setConnected(true);
                                console.log('Connected: ' + frame);

                                stompClient.subscribe('/topic/verbose', 
                                    function (response) {
                                	var responseObject = JSON.parse(response.body);
                                	if(Array.isArray(responseObject)) {
                                    	for(msg of responseObject){
                                            show(msg);
                                    	}
                                	} else {
                                        show(responseObject);
                                	}
                                });
                            }
    );
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    stompClient.send("/app/send", {}, JSON.stringify({'content': $("#content").val(), 'user': user}));
}

function show(msg) {
    // $("#messages").append("<tr><td>" + message + "</td></tr>");


            console.log(msg.date);
            var date = new Date();
            date.setTime(Date.parse(msg.date));
            var d = date.getDate();
            var m = date.getMonth()+1;
            var y = date.getFullYear();
            var h = date.getHours();
            var min = date.getMinutes();

            formattedDate = d + "/" + m + "/" + y + "  " + h + ":" + min;
            
    console.log(msg);
     var li = $("#inboundtemplate").clone();
     li.appendTo("#chat");
     li.find( "p" ).html( msg.content );
     li.find("#timestamp").html(formattedDate);
     li.find("#msgUser").html(msg.user)
     li.show();

}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    /* $( "#send" ).click(function() { }); */
});

$(document).ready(
    function() {

        // var Nombre= prompt("Nombre:");

        $('#send').click(function(){
            var now = new Date();
            console.log(now);
            var d = now.getDate();
            var m = now.getMonth()+1;
            var y = now.getFullYear();
            var h = now.getHours();
            var min = now.getMinutes();

            Fecha = d + "/" + m + "/" + y + "  " + h + ":" + min;

            /*
			 * TabladeBaseDatos.push({ Nombre:Nombre,
			 * Mensaje:$("#Mensaje").val(), Fecha:Fecha });
			 */

           sendMessage();

            var message = $("#content").val();
            var li = $("#outboundtemplate").clone();
            li.appendTo("#chat");
            li.find( "p" ).html( message );
            li.find("#timestamp").html(Fecha);
            li.show();
        });

    }
);     