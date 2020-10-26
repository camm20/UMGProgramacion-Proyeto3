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




//------------------------ CLIENTES EMPRESAS FUNCTION ---------------------//

function cliente_empresas_save(){
    dict_data = general_validate_inputs('.empresas_clients');
    if(dict_data['validate'] === true){
        loading_process();
        ajax_function('/proyecto3/agregarclienteempresas',params(dict_data), add_cliente_empresas_resp);
    }
}

function add_cliente_empresas_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        //validateObj = JSON.parse(this.responseText);
        close_windalert();
        if(this.response === 'Error'){
            msg_error();
        }else{
            document.querySelectorAll('.empresas_clients').forEach(function(node){node.value = '';});
            document.querySelector('#tbl_clientes_empresas').getElementsByTagName('tbody')[0].innerHTML = this.response;
        }   
    }
}

function edit_cliente_empresas(id){   
    dict_data = {'id':id,'action':'getDataClient'};
    ajax_function('/proyecto3/editarclienteempresas',params(dict_data), edit_cliente_empresas_form_resp);
}

function edit_cliente_empresas_form_resp(){
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

function save_edit_cliente_empresas(id){
    dict_data = general_validate_inputs('.edit_empresas_clients');
    
    if(dict_data['validate'] === true){
        loading_process();
        dict_data['id'] = id;
        dict_data['action'] = 'saveDataClient';
        ajax_function('/proyecto3/editarclienteempresas',params(dict_data), save_edit_cliente_empresas_resp);
    }
}

function save_edit_cliente_empresas_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        //validateObj = JSON.parse(this.responseText);
        close_windalert();
        if(this.response === 'Error'){
            msg_error();
        }else{
            document.querySelector('#tbl_clientes_empresas').getElementsByTagName('tbody')[0].innerHTML = this.response;
        }   
    }    
}

function inactive_cliente_empresas(id){
    loading_process();
    dict_data['id'] = id;
    dict_data['action'] = 'inactiveDataClient';
    ajax_function('/proyecto3/editarclienteempresas',params(dict_data), inactive_cliente_empresas_resp);
}

function inactive_cliente_empresas_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        //validateObj = JSON.parse(this.responseText);
        close_windalert();
        if(this.response === 'Error'){
            msg_error();
        }else{
            document.querySelector('#tbl_clientes_empresas').getElementsByTagName('tbody')[0].innerHTML = this.response;
        }   
    }    
}

//------------------------ CLIENTES EMPRESAS FUNCTION ---------------------//



//------------------------ PRODUCTOS FUNCTION -------------------------//

function new_producto_save(){
    dict_data = general_validate_inputs('.new_producto');
    if(dict_data['validate'] === true){
        dict_data['action'] = 'addNewDataProduct';
        loading_process();
        ajax_function('/proyecto3/manageproducts',params(dict_data), add_producto_resp);
    }   
}

function add_producto_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        //validateObj = JSON.parse(this.responseText);
        close_windalert();
        if(this.response === 'Error'){
            msg_error();
        }else{
            document.querySelectorAll('.new_producto').forEach(function(node){node.value = '';});
            document.querySelector('#tbl_productos').getElementsByTagName('tbody')[0].innerHTML = this.response;
        }   
    }
}

function edit_producto(id){
    dict_data = {'id':id,'action':'getDataProduct'};
    ajax_function('/proyecto3/manageproducts',params(dict_data), edit_product_form_resp);
}

function edit_product_form_resp(){
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


function save_edit_producto(id){
    dict_data = general_validate_inputs('.edit_producto');
    
    if(dict_data['validate'] === true){
        loading_process();
        dict_data['id'] = id;
        dict_data['action'] = 'saveDataProduct';
        ajax_function('/proyecto3/manageproducts',params(dict_data), save_edit_product_resp);
    }
}

function save_edit_product_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        //validateObj = JSON.parse(this.responseText);
        close_windalert();
        if(this.response === 'Error'){
            msg_error();
        }else{
            document.querySelector('#tbl_productos').getElementsByTagName('tbody')[0].innerHTML = this.response;
        }   
    }    
}

function inactive_producto(id){
    loading_process();
    dict_data = {'id':id,'action':'inactiveDataProduct'};
    ajax_function('/proyecto3/manageproducts',params(dict_data), inactive_product_resp);
}

function inactive_product_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        //validateObj = JSON.parse(this.responseText);
        close_windalert();
        if(this.response === 'Error'){
            msg_error();
        }else{
            document.querySelector('#tbl_productos').getElementsByTagName('tbody')[0].innerHTML = this.response;
        }   
    }    
}

//------------------------ PRODUCTOS FUNCTION -------------------------//

//-------------------------- OC ALTAS ----------------------------//

function alta_oc_search_client(){
    idClient = document.getElementById("cod_client").value;
    if(idClient !== ""){
        loading_process();
        dict_data = {"idCliente":idClient,"action":"altaOC"};
        ajax_function('/proyecto3/managoc',params(dict_data), alta_oc_resp);
    }
}

function alta_oc_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        close_windalert();
        if(this.response === 'Error'){
            msg_error();
        }else{
            document.getElementById("btn_buscar_cliente_oc").disabled = true;
            document.getElementById("cod_client").disabled = true;
            document.getElementById("btn_end_alta_oc").disabled = false;
            document.querySelector('.container-fluid').insertAdjacentHTML('beforeEnd',this.response);
        }   
    }    
}

function alta_oc_end_process(){
    document.getElementById("btn_buscar_cliente_oc").disabled = false;
    document.getElementById("cod_client").disabled = false;
    document.getElementById("cod_client").value = "";
    document.getElementById("btn_end_alta_oc").disabled = true;
    nodes = document.querySelector('.container-fluid');
    while (nodes.childElementCount > 2) {  
        nodes.removeChild(nodes.children[nodes.childElementCount - 1]);
    }
}

function oc_add_item(){
    dict_data = general_validate_inputs('.oc_add_item');
    if(dict_data['validate'] === true){
        loading_process();
        dict_data['action'] = 'addItemOC';
        ajax_function('/proyecto3/managoc',params(dict_data), oc_add_item_resp);
    }    
}

function oc_add_item_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        close_windalert();
        document.querySelectorAll(".oc_add_item").forEach(function(node){node.value="";});
        if(this.response === 'No Product'){
            var html_msg = `<div class="header-login-container" style="background-color:red;">
                                    <label>ERROR</label>
                                    <p id="btn-close-alert" class="btn-close-alertclass" onclick="close_windalert()">X</p>
                            </div>
                            <div class="content-msg-container">
                                    <p style="font-size:20px;">El codigo de producto no existe en el sistema.</p>
                                    <button class="btn btn-danger" onclick="close_windalert()">Aceptar</button>
                            </div>`;

            document.getElementById('msg-content').innerHTML = html_msg;
            document.getElementsByClassName('window-msg-general')[0].style.display="inline-block";
            document.body.style.overflowY = "hidden";
        }else{
            document.getElementById('tbl_oc_items').getElementsByTagName("tbody")[0].innerHTML = this.response;
        }   
    }
}



//-------------------------- OC ALTAS ----------------------------//

//-------------------------- OC BAJAS ----------------------------//

function baja_oc_search(){
    dict_data = general_validate_inputs('.baja_oc_search');
    if(dict_data['validate'] === true){
        loading_process();
        dict_data['action'] = 'bajaSearchOC';
        ajax_function('/proyecto3/managoc',params(dict_data), baja_search_oc_resp);
    }
}

function baja_search_oc_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        close_windalert();
        document.querySelectorAll(".bajas_oc_search").forEach(function(node){node.value="";});
        if(this.response === 'Error'){
            msg_error();
        }else if(this.response === 'No OC'){
            var html_msg = `<div class="header-login-container" style="background-color:red;">
                                    <label>ERROR</label>
                                    <p id="btn-close-alert" class="btn-close-alertclass" onclick="close_windalert()">X</p>
                            </div>
                            <div class="content-msg-container">
                                    <p style="font-size:20px;">La Orden de Compra no existe en el sistema.</p>
                                    <button class="btn btn-danger" onclick="close_windalert()">Aceptar</button>
                            </div>`;

            document.getElementById('msg-content').innerHTML = html_msg;
            document.getElementsByClassName('window-msg-general')[0].style.display="inline-block";
            document.body.style.overflowY = "hidden";
        }else{
            document.getElementById("btn_baja_search_oc").disabled = true;
            document.getElementById("cod_oc").disabled = true;
            document.getElementById("btn_cancel_baja_oc").disabled = false;
            document.getElementById("btn_save_baja_oc").disabled = false;
            document.querySelector('.container-fluid').insertAdjacentHTML('beforeEnd',this.response);
        }   
    }    
}

function baja_oc_cancel_process(){
    document.getElementById("btn_baja_search_oc").disabled = false;
    document.getElementById("cod_oc").disabled = false;
    document.getElementById("cod_oc").value = "";
    document.getElementById("btn_cancel_baja_oc").disabled = true;
    document.getElementById("btn_save_baja_oc").disabled = true;
    nodes = document.querySelector('.container-fluid');
    while (nodes.childElementCount > 2) {  
        nodes.removeChild(nodes.children[nodes.childElementCount - 1]);
    }
}

function baja_oc_acept_process(){
    dict_data = general_validate_inputs('.baja_oc_search');
    if(dict_data['validate'] === true){
        loading_process();
        dict_data['action'] = 'bajaAceptOC';
        ajax_function('/proyecto3/managoc',params(dict_data), baja_oc_acept_resp);
    }
}

function baja_oc_acept_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        close_windalert();
        document.querySelectorAll(".bajas_oc_search").forEach(function(node){node.value="";});
        if(this.response === 'Error'){
            msg_error();
        }else if(this.response === 'Success'){
            baja_oc_cancel_process();
            var html_msg = `<div class="header-login-container">
                                    <label>SUCCESS</label>
                                    <p id="btn-close-alert" class="btn-close-alertclass" onclick="close_windalert()">X</p>
                            </div>
                            <div class="content-msg-container">
                                    <p style="font-size:20px;">La Orden de Compra ha sido dada de baja.</p>
                                    <button class="btn btn-primary" onclick="close_windalert()">Aceptar</button>
                            </div>`;

            document.getElementById('msg-content').innerHTML = html_msg;
            document.getElementsByClassName('window-msg-general')[0].style.display="inline-block";
            document.body.style.overflowY = "hidden";
        }
    }
    
}

//-------------------------- OC BAJAS ----------------------------//


//-------------------------- REPORT OC ----------------------------//

function report_oc_search(){
    dict_data = general_validate_inputs('.report_oc_search');
    if(dict_data['validate'] === true){
        loading_process();
        dict_data['action'] = 'getReportOC';
        ajax_function('/proyecto3/managereports',params(dict_data), report_oc_search_resp);
    }
}

function report_oc_search_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        close_windalert();
        
        if(this.response === 'Error'){
            msg_error();
        }else if(this.response === 'No OC'){
            var html_msg = `<div class="header-login-container" style="background-color:red;">
                                    <label>ERROR</label>
                                    <p id="btn-close-alert" class="btn-close-alertclass" onclick="close_windalert()">X</p>
                            </div>
                            <div class="content-msg-container">
                                    <p style="font-size:20px;">La Orden de Compra no existe en el sistema.</p>
                                    <button class="btn btn-danger" onclick="close_windalert()">Aceptar</button>
                            </div>`;

            document.getElementById('msg-content').innerHTML = html_msg;
            document.getElementsByClassName('window-msg-general')[0].style.display="inline-block";
            document.body.style.overflowY = "hidden";
        }else{
            document.getElementById("btn_report_oc_search").disabled = true;
            document.getElementById("cod_oc").disabled = true;
            document.getElementById("btn_report_oc_clear").disabled = false;
            document.querySelector('.container-fluid').insertAdjacentHTML('beforeEnd',this.response);
        }   
    }    
}

function report_oc_clear(){
    document.getElementById("btn_report_oc_search").disabled = false;
    document.getElementById("cod_oc").disabled = false;
    document.getElementById("cod_oc").value = "";
    document.getElementById("btn_report_oc_clear").disabled = true;
    nodes = document.querySelector('.container-fluid');
    while (nodes.childElementCount > 2) {  
        nodes.removeChild(nodes.children[nodes.childElementCount - 1]);
    }
}

//-------------------------- REPORT OC ----------------------------//


//-------------------------- REPORT CLIENTS ----------------------//

function report_client_select(){
    dict_data = general_validate_inputs('.select_report_clients');
    if(dict_data['validate'] === true){
        loading_process();
        dict_data['action'] = 'getReportClients';
        console.log(dict_data);
        ajax_function('/proyecto3/managereports',params(dict_data), report_client_resp);
    }
}

function report_client_resp(){
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        close_windalert();
        if(this.response === 'Error'){
            msg_error();
        }else{
            console.log(this.response);
            document.getElementById("report_clients").innerHTML = this.response;
        }
    }    
}
//-------------------------- REPORT CLIENTS ----------------------//


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
				
                if(['text','password','file','number'].includes(cnode.type)){
                    dict_data[cnode.getAttribute('id')] = cnode.value;
                }

            }else if(cnode.tagName === 'SELECT'){
                dict_data[cnode.getAttribute('id')] = cnode.selectedOptions[0].value;
            }
        }else if(cnode.hasAttribute('validate') && cnode.getAttribute('validate') === "1"){
            if(cnode.tagName === 'INPUT'){
				
                if(['text','password','file','number'].includes(cnode.type)){
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