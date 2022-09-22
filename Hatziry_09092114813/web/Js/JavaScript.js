/* global formData, Swal */

window.onload = function () {
    //Ejecución de recarga de página 
};

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
            cleanForm();
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

function cleanForm() {
    document.getElementById("code").value = '';
    document.getElementById("name").value = '';
    document.getElementById("lastname").value = '';
    document.getElementById("email").value = '';
    document.getElementById("pass").value = '';
    document.getElementById("phone").value = '';
    document.getElementById("address").value = '';
    document.getElementById("muni").value = '';
    document.getElementById("city").value = '';
}

function eliminar3(codigo) {
    const XHR = new XMLHttpRequest();
    var formData = new URLSearchParams(new FormData());

    // Define what happens in case of error
    XHR.addEventListener('error', (event) => {
        console.log('Oops! Something went wrong.');
    });

    // Set up our request
    XHR.open('POST', 'ClienteController', true);
    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    XHR.onload = () => {
        if (XHR.readyState === XHR.DONE && XHR.status === 200) {
            console.log("response => " + XHR.response);
            deleted();
            setTimeout(function () {
                window.location.reload();
            }, 2000);
        }
    };
    formData.append('codigo_cliente', codigo);
    formData.append('control', 'ELIMINAR');
    XHR.send(formData);
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



