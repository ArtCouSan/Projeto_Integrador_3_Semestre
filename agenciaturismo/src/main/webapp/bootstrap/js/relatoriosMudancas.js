function pesquisar() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.addEventListener("load", listar);
    xmlhttp.open("GET", "BuscarRelatorioMudanca");
    xmlhttp.send();
}

function listar(evt) {

    var texto = (evt.target.responseText);

    var obj = JSON.parse(texto);

    var table = document.getElementById("resultado");

    while (table.firstChild) {
        table.removeChild(table.firstChild);
    }

    for (var item in obj) {

        var tr2 = document.createElement("tr");

        var tdF = document.createElement("td");
        var filialD = document.createTextNode(obj[item].filial);
        tdF.appendChild(filialD);

        var tdM = document.createElement("td");
        var mudancaD = document.createTextNode(obj[item].mudanca);
        tdM.appendChild(mudancaD);

        var tdC = document.createElement("td");
        var cargoD = document.createTextNode(obj[item].cargo);
        tdC.appendChild(cargoD);

        var tdD = document.createElement("td");
        var data_D = document.createTextNode(obj[item].data);
        tdD.appendChild(data_D);

        tr2.appendChild(tdF);
        tr2.appendChild(tdM);
        tr2.appendChild(tdC);
        tr2.appendChild(tdD);

        table.appendChild(tr2);

    }

}

window.addEventListener("load", pesquisar);