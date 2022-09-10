/* global formData, Swal */

window.onload = function () {
    //Ejecución de recarga de página 
};

/*function obteniendoElementosDom(){
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
 }*/

function enviarDatos() {
    const XHR = new XMLHttpRequest();
    var formData = new URLSearchParams(new FormData(document.getElementById('form'))).toString();

    XHR.addEventListener('error', (event) => {
        console.log('Upps.. Algo salió mal');
    });
    XHR.open('POST', 'ClienteController', true);
    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    XHR.onload = () => {
        if (XHR.readyState === XHR.DONE && XHR.status === 200) {
            console.log("Respuesta => " + XHR.response);
            document.getElementById('bodyTable').innerHTML = XHR.response;
            success();
        }
    };
    XHR.send(formData);
}
function eliminar() {
    let btn = document.getElementById('btn1');
    btn.addEventListener("click", (event) => {
        event.target.parentNode.parentNode.remove();
        deleted();
    });
}

function eliminar2(iterador) {
    let data = "Posición #" + iterador;
    const XHR = new XMLHttpRequest();
    XHR.addEventListener('error', (event) => {
        console.log('Upps.. Algo salió mal');
    });
    XHR.open('POST', 'ClienteController', true);
    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    XHR.onload = () => {
        if (XHR.readyState === XHR.DONE && XHR.status === 200) {
            console.log("Respuesta => " + XHR.response);
            document.getElementById('bodyTable').innerHTML = XHR.response;
            deleted();
        }
    };
    XHR.send(data);
}

function success() {
    const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 3000,
        timerProgressBar: true,
        didOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer);
            toast.addEventListener('mouseleave', Swal.resumeTimer);
        }
    });

    Toast.fire({
        icon: 'success',
        title: 'Registrado exitosamente!'
    });
}

function deleted() {
    Swal.fire({
        title: 'Registro eliminado exitosamente!',
        width: 600,
        padding: '3em',
        color: '#fff',
        background: '#fff url(https://b.rgbimg.com/users/x/xy/xymonau/600/mgZP6rW.jpg)',
        backdrop: `
    rgba(0,0,123,0.4)
    url("https://64.media.tumblr.com/1ba85ab48165850add73e21e84380427/81638282add66aaa-cb/s540x810/556c3d985b7e469e496d0bfdd1af3b20d7f17369.gifv")
    left top
    no-repeat
  `
    });
}



