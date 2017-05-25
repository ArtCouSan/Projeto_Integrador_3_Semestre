function showHint(busca) {
    if (busca.length === 0) {
        document.getElementById("pesquisaHotel").innerHTML = "";
        return;
    } else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.addEventListener("load", listar);
        xmlhttp.open("GET", "BuscarHotelVenda?busca=" + busca);
        xmlhttp.send();
    }
}

function listar(evt) {

    var texto = (evt.target.responseText);

    var obj = JSON.parse(texto);

    for (var item of obj) {

        console.log(item);
    }

}