/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//------------------------ LOGIN FUNCTION ---------------------//
function login_key(e){
    if(this.document.activeElement.id === 'login_user'){
        if(e.key === 'Enter'){
                document.getElementById('login_password').focus();
        }
    }else if(this.document.activeElement.id === 'login_password'){
        if(e.key === 'Enter'){
                login();
        }
    }
}

function login(){
    dict_data = general_validate_inputs('.login_form');
    if(dict_data['validate'] === true){
        //ajax_function_json('/proyecto3/login',JSON.stringify(dict_data), null);
        ajax_function('login',params(dict_data), login_resp);
    }
}

function login_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        //validateObj = JSON.parse(this.responseText);
        if(this.response === '1'){
            setTimeout(function(){
                window.location = "dashboard.jsp";
            }, 100);
        }else{
            document.getElementById("login_error_msg").innerText = "Usuario y/o Password incorrectos."
        }   
    }
    
}

//------------------------ LOGIN FUNCTION ---------------------//

//------------------------ CLIENTES INDIVIDUAL FUNCTION ---------------------//

function cliente_individual_save(){
    dict_data = general_validate_inputs('.individual_clients');
    if(dict_data['validate'] === true){
        loading_process();
        ajax_function('/proyecto3/agregarclienteindividual',params(dict_data), add_cliente_individual_resp);
    }
}

function add_cliente_individual_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        //validateObj = JSON.parse(this.responseText);
        close_windalert();
        if(this.response === 'Error'){
            msg_error();
        }else{
            document.querySelectorAll('.individual_clients').forEach(function(node){node.value = '';});
            document.querySelector('#tbl_clientes_individuales').getElementsByTagName('tbody')[0].innerHTML = this.response;
        }   
    }
}

function edit_cliente_individual(id){   
    dict_data = {'id':id,'action':'getDataClient'};
    ajax_function('/proyecto3/editarclienteindividual',params(dict_data), edit_cliente_individual_form_resp);
}

function edit_cliente_individual_form_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        //validateObj = JSON.parse(this.responseText);
        if(this.response === 'Error'){
            msg_error();
        }else{
            document.getElementById('msg-content').innerHTML = this.response;
            document.getElementsByClassName('window-msg-general')[0].style.display="inline-block";
            document.body.style.overflowY = "hidden";
        }   
    }    
}

function save_edit_cliente_individual(id){
    dict_data = general_validate_inputs('.edit_individual_clients');
    
    if(dict_data['validate'] === true){
        loading_process();
        dict_data['id'] = id;
        dict_data['action'] = 'saveDataClient';
        ajax_function('/proyecto3/editarclienteindividual',params(dict_data), save_edit_cliente_individual_resp);
    }
}

function save_edit_cliente_individual_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        //validateObj = JSON.parse(this.responseText);
        close_windalert();
        if(this.response === 'Error'){
            msg_error();
        }else{
            document.querySelector('#tbl_clientes_individuales').getElementsByTagName('tbody')[0].innerHTML = this.response;
        }   
    }    
}

function inactive_cliente_individual(id){
    loading_process();
    dict_data['id'] = id;
    dict_data['action'] = 'inactiveDataClient';
    ajax_function('/proyecto3/editarclienteindividual',params(dict_data), inactive_cliente_individual_resp);
}

function inactive_cliente_individual_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        //validateObj = JSON.parse(this.responseText);
        close_windalert();
        if(this.response === 'Error'){
            msg_error();
        }else{
            document.querySelector('#tbl_clientes_individuales').getElementsByTagName('tbody')[0].innerHTML = this.response;
        }   
    }    
}

//------------------------ CLIENTES INDIVIDUAL FUNCTION ---------------------//



//------------------------ GENERAL PROPOUSE FUNCTIONS ------------------------//
function loading_process(){
    msg_preloud = '<div id="loader-container">\
                      <p id="loadingText">Loading</p>\
                    </div>';
    document.getElementById('msg-content').innerHTML = msg_preloud;
    document.getElementsByClassName('window-msg-general')[0].style.display="inline-block";
    document.getElementsByClassName('window-msg-general')[0].style.backgroundColor = 'rgba(0, 0, 0, 0.26)';
    document.body.style.overflowY = "hidden";
}

function close_windalert() {
    var element = document.getElementById('msg-content');
    document.body.style.overflowY = "initial";
    while (element.firstChild) {
        element.removeChild(element.firstChild);
    }
    document.querySelectorAll('.window-msg-general').forEach(function(window){
        window.style.display="none";
    });
}

function close_workform(){
    document.body.style.overflowY = "initial";
    document.getElementsByClassName('window-workfunction-general')[0].style.display="none";
}

function msg_error(){
    var html_msg = `<div class="header-login-container" style="background-color:red;">
                            <label>ERROR</label>
                            <p id="btn-close-alert" class="btn-close-alertclass" onclick="close_windalert()">X</p>
                    </div>
                    <div class="content-msg-container">
                            <p style="font-size:20px;">ERROR! Notificar al administrador del sistema.</p>
                            <button class="btn btn-danger" onclick="close_windalert()">Aceptar</button>
                    </div>`;

    document.getElementById('msg-content').innerHTML = html_msg;
    document.getElementsByClassName('window-msg-general')[0].style.display="inline-block";
    document.body.style.overflowY = "hidden";
}

function params(object) {
    var encodedString = '';
    for (var prop in object) {
        if (object.hasOwnProperty(prop)) {
            if (encodedString.length > 0) {
                encodedString += '&';
            }
            encodedString += encodeURI(prop + '=' + object[prop]);
        }
    }
    return encodedString;
}

function general_validate_inputs(class_name){
    check_data = true;
    dict_data = {};
    document.querySelectorAll(class_name).forEach(function(cnode){
        
        if(cnode.hasAttribute('validate') && cnode.getAttribute('validate') === "0"){
            if(cnode.tagName === 'INPUT'){
				
				if(['text','password','file'].includes(cnode.type)){
					dict_data[cnode.getAttribute('id')] = cnode.value;
				}

            }else if(cnode.tagName === 'SELECT'){
                dict_data[cnode.getAttribute('id')] = cnode.selectedOptions[0].value;
            }
        }else if(cnode.hasAttribute('validate') && cnode.getAttribute('validate') === "1"){
            if(cnode.tagName === 'INPUT'){
				
				if(['text','password','file'].includes(cnode.type)){
					if(cnode.value !== ''){
						cnode.style.backgroundColor = '#ffffff';
						dict_data[cnode.getAttribute('id')] = cnode.value;
					}else{
						check_data = false;
						cnode.style.backgroundColor = '#ffa6a6';
					}
                }
                
            }else if(cnode.tagName === 'SELECT'){
                if(cnode.selectedOptions[0].value !== ''){
                    cnode.style.backgroundColor = '#ffffff';
                    dict_data[cnode.getAttribute('id')] = cnode.selectedOptions[0].value;
                }else{
                    check_data = false;
                    cnode.style.backgroundColor = '#ffa6a6';
                }
            }
        }
        
    });
    dict_data['validate'] = check_data;
    return dict_data;
}


//------------------------ GENERAL PROPOUSE FUNCTIONS ------------------------//