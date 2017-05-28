function pesquisaHotel() {
    var busca = document.querySelector(".pesquisaHotel").value;
    if (busca.length === 0) {
        document.querySelector(".pesquisaHotel").innerHTML = "";
        return;
    } else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.addEventListener("load", listarHotel);
        xmlhttp.open("GET", "BuscarHotelVenda?busca=" + busca);
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

    var texto = (evt.target.responseText);

    var obj = JSON.parse(texto);

    var table = document.getElementById("table");

    if (table.hasChildNodes()) {
        table.removeChild(table.childNodes[0]);
    }

    var thead = document.createElement("thead");

    var tr = document.createElement("tr");

    var thO = document.createElement("th");
    var origem = document.createTextNode("Origem");
    thO.appendChild(origem);

    var thDe = document.createElement("th");
    var destino = document.createTextNode("Destino");
    thDe.appendChild(destino);

    var thDi = document.createElement("th");
    var data_i = document.createTextNode("Data de ida");
    thDi.appendChild(data_i);

    var thDv = document.createElement("th");
    var data_v = document.createTextNode("Data de volta");
    thDv.appendChild(data_v);

    var thQp = document.createElement("th");
    var qtd_p = document.createTextNode("Quantidade de passagens");
    thQp.appendChild(qtd_p);

    var thP = document.createElement("th");
    var preco = document.createTextNode("Preco");
    thP.appendChild(preco);

    tr.appendChild(thO);
    tr.appendChild(thDi);
    tr.appendChild(thDi);
    tr.appendChild(thDv);
    tr.appendChild(thQp);
    tr.appendChild(thP);

    thead.appendChild(tr);

    table.appendChild(thead);

    var tbody = document.createElement("tbody");

    for (var item of obj) {

        var tr2 = document.createElement("tr");
        var tdO = document.createElement("td");
        var nomeD = obj;
        console.log(item);
        tdN.appendChild(nomeD);
        var tdD = document.createElement("td");
        var data_eD;
        tdDe.appendChild(data_eD);
        var tdDi = document.createElement("td");
        var data_sD;
        tdDs.appendChild(data_sD);
        var tdDv = document.createElement("td");
        var precoD;
        tdP.appendChild(precoD);
        var tdQp = document.createElement("td");
        var qtd_qD;
        tdQq.appendChild(qtd_qD);
        var tdP = document.createElement("td");
        var qtd_hD;
        tdQh.appendChild(qtd_hD);

        tr2.appendChild(tdN);
        tr2.appendChild(tdDe);
        tr2.appendChild(tdDs);
        tr2.appendChild(tdP);
        tr2.appendChild(tdQq);
        tr2.appendChild(tdQh);

        tbody.appendChild(tr2);

    }

    table.appendChild(tbody);

}

function listarHotel(evt) {

    var texto = (evt.target.responseText);

    var obj = JSON.parse(texto);

    var table = document.getElementById("table");

    if (table.hasChildNodes()) {
        table.removeChild(table.childNodes[0]);
    }

    var thead = document.createElement("thead");

    var tr = document.createElement("tr");

    var thN = document.createElement("th");
    var nome = document.createTextNode("Nome");
    thN.appendChild(nome);

    var thDe = document.createElement("th");
    var data_e = document.createTextNode("Data de entrada");
    thDe.appendChild(data_e);

    var thDs = document.createElement("th");
    var data_s = document.createTextNode("Data de saida");
    thDs.appendChild(data_s);

    var thP = document.createElement("th");
    var preco = document.createTextNode("Preco");
    thP.appendChild(preco);

    var thQq = document.createElement("th");
    var qtd_q = document.createTextNode("Quantidade de quartos");
    thQq.appendChild(qtd_q);

    var thQh = document.createElement("th");
    var qtd_h = document.createTextNode("Quantidade de hospedes");
    thQh.appendChild(qtd_h);

    tr.appendChild(thN);
    tr.appendChild(thDe);
    tr.appendChild(thDs);
    tr.appendChild(thP);
    tr.appendChild(thQq);
    tr.appendChild(thQh);

    thead.appendChild(tr);

    table.appendChild(thead);

    var tbody = document.createElement("tbody");

    for (var item of obj) {

        var tr2 = document.createElement("tr");
        var tdN = document.createElement("td");
        var nomeD = obj
        console.log(item);
        tdN.appendChild(nomeD);
        var tdDe = document.createElement("td");
        var data_eD;
        tdDe.appendChild(data_eD);
        var tdDs = document.createElement("td");
        var data_sD;
        tdDs.appendChild(data_sD);
        var tdP = document.createElement("td");
        var precoD;
        tdP.appendChild(precoD);
        var tdQq = document.createElement("td");
        var qtd_qD;
        tdQq.appendChild(qtd_qD);
        var tdQh = document.createElement("td");
        var qtd_hD;
        tdQh.appendChild(qtd_hD);

        tr2.appendChild(tdN);
        tr2.appendChild(tdDe);
        tr2.appendChild(tdDs);
        tr2.appendChild(tdP);
        tr2.appendChild(tdQq);
        tr2.appendChild(tdQh);

        tbody.appendChild(tr2);

    }

    table.appendChild(tbody);

}