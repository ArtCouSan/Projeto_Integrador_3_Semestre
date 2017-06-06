function pesquisar() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.addEventListener("load", listar);
    xmlhttp.open("GET", "BuscarSLAServlet");
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
        var mudancaD = document.createTextNode(obj[item].mensagem);
        tdM.appendChild(mudancaD);

        var tdN = document.createElement("td");
        var nomeD = document.createTextNode(obj[item].nome);
        tdN.appendChild(nomeD);

        var tdC = document.createElement("td");
        var cargoD = document.createTextNode(obj[item].cargo);
        tdC.appendChild(cargoD);

        var tdD = document.createElement("td");
        var data_D = document.createTextNode(obj[item].data_m);
        tdD.appendChild(data_D);

        var tdB = document.createElement("td");
        var a = document.createElement("a");
        var classe = document.createAttribute("class");
        classe.value = "btn btn-danger";
        var style = document.createAttribute("style");
        style.value = "width: 100px";
        var href = document.createAttribute("href");
        href.value = "ExcluiSLAServlet?id=" + obj[item].id_sla;
        a.setAttributeNode(classe);
        a.setAttributeNode(style);
        a.setAttributeNode(href);
        var i = document.createElement("i");
        var classe2 = document.createAttribute("class");
        classe2.value = "glyphicon glyphicon-trash";
        var texto = document.createTextNode("Remover");
        i.setAttributeNode(classe2);
        i.appendChild(texto);
        a.appendChild(i);
        tdB.appendChild(a);

        tr2.appendChild(tdF);
        tr2.appendChild(tdM);
        tr2.appendChild(tdN);
        tr2.appendChild(tdC);
        tr2.appendChild(tdD);
        tr2.appendChild(tdB);

        table.appendChild(tr2);

    }

}

window.addEventListener("load", pesquisar);