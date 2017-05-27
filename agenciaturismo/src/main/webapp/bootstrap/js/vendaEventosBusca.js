function pesquisaHotel() {
    var busca = document.querySelector(".pesquisaHotel").value;
    if (busca.length === 0) {
        document.querySelector(".pesquisaHotel").innerHTML = "";
        return;
    } else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("GET", "BuscarHotelVenda?busca=" + busca);
        xmlhttp.addEventListener("load", listarHotel);
        xmlhttp.send();
    }
}

function listarHotel(evt) {

    var texto = (evt.target.responseText);

    var obj = JSON.parse(texto);

    for (var item of obj) {

        console.log(item);
    }

}

function pesquisaVoo() {
    var busca = document.querySelector(".pesquisaVoo").value;
    if (busca.length === 0) {
        document.querySelector(".pesquisaVoo").innerHTML = "";
        return;
    } else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.addEventListener("load", listarVoo);
        xmlhttp.open("GET", "BuscarVooVenda?busca=" + busca);
        xmlhttp.send();
    }
}

function listarVoo(evt) {

//    var texto = (evt.target.responseText);
//
//    var obj = JSON.parse(texto);

    var table = document.querySelector(".table .table-striped");


//    for (var item of obj) {
//
//        console.log(item);
//    }

}

function listarHotel(evt) {

    var texto = (evt.target.responseText);

    var obj = JSON.parse(texto);

    var table = document.getElementsByName("table");

    var html = '<thead>\n\
    <tr class="info">\n\
    <th>Nome</th>\n\
    <th>Data de entrada</th>\n\
    <th>Data de saida</th>\n\
    <th>Preco</th>\n\
    <th>Quantidade de quartos</th>\n\
    <th>Quantidade de hospedes</th>\n\
    <th></th>\n\
    </tr>\n\
    </thead>\n\
    <tbody>';

    for (var item in obj) {

        //html += '<td name=' + item.

    }

    html += '</tbody>';

    table.innerHTML += html;

}