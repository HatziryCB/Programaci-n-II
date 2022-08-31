window.onload=function(){
   //Ejecución de recarga de página 
}

function obteniendoElementosDom(){
    let cliente = new Object(); //Creamos un objeto
    //Asignamos los valores de los inputs por sus id a variables creadas
    let nombre=document.getElementById("name");
    let apellido=document.getElementById("lastname");
    let codigo=document.getElementById("code");
    let telefono=document.getElementById("phone");
    let correo=document.getElementById("email");
    let direccion=document.getElementById("address");
    let municipio=document.getElementById("muni");
    let ciudad=document.getElementById("city");
    //Asignamos los datos de los inputs al objeto que creamos anteriormente
    cliente.nombre=name.value;
    cliente.apellido=lastname.value;
    cliente.codigo=code.value;
    cliente.telefono=phone.value;
    cliente.correo=email.value;
    cliente.direccion=address.value;
    cliente.municipio=muni.value;
    cliente.ciudad=city.value;
    //Mostramos en la consola o terminal el objeto que creamos
    console.log(cliente); 
}

let form = document.getElementById('formularioCliente');
function retornarValor(input){
    return !(input.value.trim()==='');
}
form.addEventListener('submit', (event)=> {
   requiredFields.forEach((input)=> {
      valid = valid|requireValue(input, input); 
   });
   if(!valid){
       event.preventDefault();
   }
});
function enviarDatos(){
    const XHR = new XMLHttpRequest();
    var formData = new FormData(document.getElementById('formularioCliente'));
    
    XHR.addEventListener('load', (event)=>{
       console.log('Datos enviados y respuesta en carga'); 
    });
    XHR.addEventListener('error', (event)=>{
       console.log('Upps.. Algo salió mal'); 
    });
    XHR.open('POST', '/ClienteController');
    
    XHR.send(formData);
}

