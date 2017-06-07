function pesquisar() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.addEventListener("load", listar);
    xmlhttp.open("GET", "BuscarRelatorioVendas");
    xmlhttp.send();
}

function listar(evt) {

    var texto = (evt.target.responseText);

    var obj = JSON.parse(texto);

    var resultado1 = document.getElementById("resultado1");

    while (resultado1.firstChild) {
        resultado1.removeChild(resultado1.firstChild);
    }

    for (var item in obj) {

        if (typeof obj[item].data_vendaMES == "undefined") {

            var tr2 = document.createElement("tr");

            var tdD = document.createElement("td");
            var data_D = document.createTextNode(obj[item].data_vendaANO);
            tdD.appendChild(data_D);

            var tdF = document.createElement("td");
            var filialD = document.createTextNode(obj[item].filialANO);
            tdF.appendChild(filialD);

            var tdV = document.createElement("td");
            var valorD = document.createTextNode(obj[item].valorANO);
            tdV.appendChild(valorD);

            tr2.appendChild(tdD);
            tr2.appendChild(tdF);
            tr2.appendChild(tdV);

            resultado1.appendChild(tr2);

        }

    }

    var resultado2 = document.getElementById("resultado2");

    while (resultado2.firstChild) {
        resultado2.removeChild(resultado2.firstChild);
    }

    for (var item in obj) {

        if (typeof obj[item].data_vendaANO == "undefined") {

            var tr2 = document.createElement("tr");

            var tdD = document.createElement("td");
            var data_D = document.createTextNode(obj[item].data_vendaMES);
            tdD.appendChild(data_D);

            var tdF = document.createElement("td");
            var filialD = document.createTextNode(obj[item].filialMES);
            tdF.appendChild(filialD);

            var tdV = document.createElement("td");
            var valorD = document.createTextNode(obj[item].valorMES);
            tdV.appendChild(valorD);

            tr2.appendChild(tdD);
            tr2.appendChild(tdF);
            tr2.appendChild(tdV);

            resultado2.appendChild(tr2);


        }

    }

}



window.addEventListener("load", pesquisar);