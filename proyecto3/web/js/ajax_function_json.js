/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function ajax_function(url_action, data_action,ajax_Listener){
    var data_json = new XMLHttpRequest();
	data_json.open("POST", url_action, true);
	data_json.onreadystatechange = ajax_Listener;
	data_json.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	data_json.send(data_action);
};


function ajax_function_json(url_action, data_action,ajax_Listener){
    var data_json = new XMLHttpRequest();
	data_json.open("POST", url_action, true);
	data_json.onreadystatechange = ajax_Listener;
	data_json.setRequestHeader("Content-Type", "application/json");
	data_json.send(data_action);
};