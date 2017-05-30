function pesquisar() {
    var busca = document.querySelector(".pesquisa").value;
    if (busca.length === 0) {
        var table = document.getElementById("table");
        while (table.firstChild) {
            table.removeChild(table.firstChild);
        }
        return;
    } else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.addEventListener("load", listar);
        xmlhttp.open("GET", "BuscaVenda?busca=" + busca);
        xmlhttp.send();
    }
}

//function listar(evt) {
//
//    var texto = (evt.target.responseText);
//
//    var obj = JSON.parse(texto);
//
//    var table = document.getElementById("table");
//
//    while (table.firstChild) {
//        table.removeChild(table.firstChild);
//    }
//
//    var thead = document.createElement("thead");
//
//    var tr = document.createElement("tr");
//    var info = document.createAttribute("class");
//    info.value = "danger";
//    tr.setAttributeNode(info);
//
//    var thN = document.createElement("th");
//    var nome = document.createTextNode("Nome");
//    thN.appendChild(nome);
//
//    var thDe = document.createElement("th");
//    var data_e = document.createTextNode("Data de entrada");
//    thDe.appendChild(data_e);
//
//    var thDs = document.createElement("th");
//    var data_s = document.createTextNode("Data de saida");
//    thDs.appendChild(data_s);
//
//    var thP = document.createElement("th");
//    var preco = document.createTextNode("Preco");
//    thP.appendChild(preco);
//
//    var thQq = document.createElement("th");
//    var qtd_q = document.createTextNode("Quantidade de quartos");
//    thQq.appendChild(qtd_q);
//
//    var thQh = document.createElement("th");
//    var qtd_h = document.createTextNode("Quantidade de hospedes");
//    thQh.appendChild(qtd_h);
//
//    tr.appendChild(thQq);
//    tr.appendChild(thQh);
//    tr.appendChild(thA);
//
//    thead.appendChild(tr);
//
//    table.appendChild(thead);
//
//    var tbody = document.createElement("tbody");
//
//    for (var item in obj) {
//
//        tbody.appendChild(tr2);
//
//    }
//
//    table.appendChild(tbody);
//
//}