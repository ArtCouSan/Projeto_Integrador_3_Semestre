function pesquisaHotel() {
    var busca = document.querySelector(".pesquisaHotel").value;
    if (busca.length === 0) {
        var table = document.getElementById("table");
        while (table.firstChild) {
            table.removeChild(table.firstChild);
        }
        return;
    } else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.addEventListener("load", listarHotel);
        xmlhttp.open("GET", "BuscarHotelVenda?busca=" + busca);
        xmlhttp.send();
    }
}

function pesquisaVoo() {
    var busca = document.querySelector(".pesquisaVoo").value;
    if (busca.length === 0) {
        var table = document.getElementById("table");
        while (table.firstChild) {
            table.removeChild(table.firstChild);
        }
        return;
    } else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.addEventListener("load", listarVoo);
        xmlhttp.open("GET", "BuscarVooVenda?busca=" + busca);
        xmlhttp.send();
    }
}

function listarHotel(evt) {

    var texto = (evt.target.responseText);

    var obj = JSON.parse(texto);

    var table = document.getElementById("table");

    while (table.firstChild) {
        table.removeChild(table.firstChild);
    }

    var thead = document.createElement("thead");

    var tr = document.createElement("tr");
    var info = document.createAttribute("class");
    info.value = "info";
    tr.setAttributeNode(info);

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

    var thA = document.createElement("th");
    var adicionar = document.createTextNode("Adicionar no carrinho");
    thA.appendChild(adicionar);

    tr.appendChild(thN);
    tr.appendChild(thDe);
    tr.appendChild(thDs);
    tr.appendChild(thP);
    tr.appendChild(thQq);
    tr.appendChild(thQh);
    tr.appendChild(thA);

    thead.appendChild(tr);

    table.appendChild(thead);

    var tbody = document.createElement("tbody");

    for (var item in obj) {

        var tr2 = document.createElement("tr");
        var tdN = document.createElement("td");
        var nomeD = document.createTextNode(obj[item].nome_hotel);
        tdN.appendChild(nomeD);
        var tdDe = document.createElement("td");
        var data_eD = document.createTextNode(obj[item].data_entrada);
        tdDe.appendChild(data_eD);
        var tdDs = document.createElement("td");
        var data_sD = document.createTextNode(obj[item].data_saida);
        tdDs.appendChild(data_sD);
        var tdP = document.createElement("td");
        var precoD = document.createTextNode(obj[item].preco);
        tdP.appendChild(precoD);
        var tdQq = document.createElement("td");
        var qtd_qD = document.createTextNode(obj[item].quantidade_quartos);
        tdQq.appendChild(qtd_qD);
        var tdQh = document.createElement("td");
        var qtd_hD = document.createTextNode(obj[item].quantidade_hospedes);
        tdQh.appendChild(qtd_hD);
        var buttonAd = document.createElement("button");
        var adicionar = document.createTextNode("Adicionar");
        buttonAd.appendChild(adicionar);

        tr2.appendChild(tdN);
        tr2.appendChild(tdDe);
        tr2.appendChild(tdDs);
        tr2.appendChild(tdP);
        tr2.appendChild(tdQq);
        tr2.appendChild(tdQh);
        tr2.appendChild(buttonAd);

        tbody.appendChild(tr2);

    }

    table.appendChild(tbody);

}

function listarVoo(evt) {

    var texto = (evt.target.responseText);

    var obj = JSON.parse(texto);

    var table = document.getElementById("table");

    while (table.firstChild) {
        table.removeChild(table.firstChild);
    }

    var thead = document.createElement("thead");

    var tr = document.createElement("tr");
    var info = document.createAttribute("class");
    info.value = "info";
    tr.setAttributeNode(info);

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

    var thA = document.createElement("th");
    var adicionar = document.createTextNode("Adicionar no carrinho");
    thA.appendChild(adicionar);

    tr.appendChild(thO);
    tr.appendChild(thDe);
    tr.appendChild(thDi);
    tr.appendChild(thDv);
    tr.appendChild(thQp);
    tr.appendChild(thP);
    tr.appendChild(thA);
    thead.appendChild(tr);

    table.appendChild(thead);

    var tbody = document.createElement("tbody");

    for (var item in obj) {

        var tr2 = document.createElement("tr");

        var tdO = document.createElement("td");
        var origemD = document.createTextNode(obj[item].origem);
        tdO.appendChild(origemD);
        var id1 = document.createAttribute("id");
        id1.value = "origem" + obj[item].id_voo;
        tdO.setAttributeNode(id1);

        var tdD = document.createElement("td");
        var destinoD = document.createTextNode(obj[item].destino);
        tdD.appendChild(destinoD);
        var id2 = document.createAttribute("id");
        id2.value = "destino" + obj[item].id_voo;
        tdD.setAttributeNode(id2);

        var tdDi = document.createElement("td");
        var data_iD = document.createTextNode(obj[item].data_ida);
        tdDi.appendChild(data_iD);
        var id3 = document.createAttribute("id");
        id3.value = "data_i" + obj[item].id_voo;
        tdDi.setAttributeNode(id3);

        var tdDv = document.createElement("td");
        var data_vD = document.createTextNode(obj[item].data_volta);
        tdDv.appendChild(data_vD);
        var id4 = document.createAttribute("id");
        id4.value = "data_v" + obj[item].id_voo;
        tdDv.setAttributeNode(id4);

        var tdQp = document.createElement("td");
        var qtd_pD = document.createTextNode(obj[item].quantidade_passagens);
        tdQp.appendChild(qtd_pD);
        var id5 = document.createAttribute("id");
        id5.value = "qtd_p" + obj[item].id_voo;
        tdQp.setAttributeNode(id5);

        var tdP = document.createElement("td");
        var precoD = document.createTextNode(obj[item].preco);
        tdP.appendChild(precoD);
        var id6 = document.createAttribute("id");
        id6.value = "preco" + obj[item].id_voo;
        tdP.setAttributeNode(id6);

        var buttonAd = document.createElement("button");
        var adicionar = document.createTextNode("Adicionar");
        var action = document.createAttribute("onclick");
        action.value = "addCarrinhoVoo(" + obj[item].id_voo + ")";
        buttonAd.setAttributeNode(action);
        buttonAd.appendChild(adicionar);

        tr2.appendChild(tdO);
        tr2.appendChild(tdD);
        tr2.appendChild(tdDi);
        tr2.appendChild(tdDv);
        tr2.appendChild(tdQp);
        tr2.appendChild(tdP);
        tr2.appendChild(buttonAd);

        tbody.appendChild(tr2);


    }

    table.appendChild(tbody);

}

function addCarrinhoVoo(id) {

    var verificarDuplicidade = percorrerCarrinho(id);

    if (verificarDuplicidade === true) {

        var origem = document.getElementById("origem" + id).innerText;

        var destino = document.getElementById("destino" + id).innerText;

        var data_ida = document.getElementById("data_i" + id).innerText;

        var data_volta = document.getElementById("data_v" + id).innerText;

        var quantidade_passagens = document.getElementById("qtd_p" + id).innerText;

        var preco = document.getElementById("preco" + id).innerText;

        var carrinho = document.getElementById("carrinho2");

        var tr = document.createElement("tr");
        var name0 = document.createAttribute("name");
        name0.value = id;
        tr.setAttributeNode(name0);

        var idTag = document.createAttribute("id");
        idTag.value = id;
        tr.setAttributeNode(idTag);

        var tdO = document.createElement("td");
        var origemD = document.createTextNode(origem);
        tdO.appendChild(origemD);
        var name1 = document.createAttribute("name");
        name1.value = "origem";
        tdO.setAttributeNode(name1);

        var tdD = document.createElement("td");
        var destinoD = document.createTextNode(destino);
        tdD.appendChild(destinoD);
        var name2 = document.createAttribute("name");
        name2.value = "destino";
        tdD.setAttributeNode(name2);

        var tdDi = document.createElement("td");
        var data_iD = document.createTextNode(data_ida);
        tdDi.appendChild(data_iD);
        var name3 = document.createAttribute("name");
        name3.value = "data_i";
        tdDi.setAttributeNode(name3);

        var tdDv = document.createElement("td");
        var data_vD = document.createTextNode(data_volta);
        tdDv.appendChild(data_vD);
        var name4 = document.createAttribute("name");
        name4.value = "data_v";
        tdDv.setAttributeNode(name4);

        var tdQp = document.createElement("td");
        var qtd_pD = document.createTextNode(quantidade_passagens);
        tdQp.appendChild(qtd_pD);
        var name5 = document.createAttribute("name");
        name5.value = "qtd_p";
        tdQp.setAttributeNode(name5);

        var tdP = document.createElement("td");
        var precoD = document.createTextNode(preco);
        tdP.appendChild(precoD);
        var name6 = document.createAttribute("name");
        name6.value = "preco";
        tdP.setAttributeNode(name6);

        var buttonR = document.createElement("button");
        var remover = document.createTextNode("Remover");

        buttonR.appendChild(remover);

        tr.appendChild(tdO);
        tr.appendChild(tdD);
        tr.appendChild(tdDi);
        tr.appendChild(tdDv);
        tr.appendChild(tdQp);
        tr.appendChild(tdP);
        tr.appendChild(buttonR);

        carrinho.appendChild(tr);

    }

}

function percorrerCarrinho(id) {

    var table = document.getElementById("carrinho2");

    var tamanho = table.rows.length;

    for (var i = 0; i < tamanho; i++) {

        if (table.rows[i].id == id) {

            return false;

        } 

    }

    return true;

}