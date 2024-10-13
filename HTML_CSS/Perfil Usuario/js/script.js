const d = document;
function subirImagen(e){
    let files = e.target.files;

    let imagen = files[0];

    let imagenURL = URL.createObjectURL(imagen);

    d.querySelector(".profile .img").style.backgroundImage = "url('"+ imagenURL +"')";
}

d.querySelector("#file-uploader").addEventListener("change", subirImagen)


