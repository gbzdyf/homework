var url = 'ws://'+window.location.hostname+':8080/web/robot';  
var ws = new WebSocket(url);

$(document).ready(function () {
    ws.onopen = function(event)  
    {    
        ws.send('hello');    
    };    
    ws.onmessage = function(event) {  
        creatRecvDiv(event.data);  
    };  
      
    ws.onerror = function(event) {  
        alert(event);  
    }  	
$("#sendBtn").click((function() {creatSendDiv();}));});

function creatSendDiv() {
	      var msg=$("#mywords").val();
	      ws.send(msg);
	      $("<div/>", { "class": "chat-widget-left"})
	      .append(msg)
	      .appendTo("#chat-main");   
        $("<div/>", { "class": "chat-widget-name-left"})
       .append($("<h4>Power Man</h4>"))
       .appendTo("#chat-main");
       $("#widget-main").scroll()
    }

function creatRecvDiv(msg) {
	      $("<div/>", { "class": "chat-widget-right"})
	      .append(msg)
	      .appendTo("#chat-main");   
        $("<div/>", { "class": "chat-widget-name-right"})
       .append($("<h4>Little Robot </h4>"))
       .appendTo("#chat-main");
       $("#widget-main").scroll()
    }
    
