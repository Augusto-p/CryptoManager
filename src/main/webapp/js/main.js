function isImage() {
    var url = document.getElementById("logo").value;
    const result = document.getElementById("valid");
    url = url.toLowerCase();
    if ((url.indexOf("https://") != -1 || url.indexOf("http://") != -1)&&(url.indexOf(".jpeg") != -1 || url.indexOf(".jpg") != -1 || url.indexOf(".gif") != -1 || url.indexOf(".png") != -1)) {
        result.textContent = "Imagen valida";
    }else{
        result.textContent = "Imagen no valida";
    }

}