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
    info.value = "danger";
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
        var id1 = document.createAttribute("id");
        id1.value = "nome" + obj[item].id_hotel;
        tdN.setAttributeNode(id1);

        var tdDe = document.createElement("td");
        var data_eD = document.createTextNode(obj[item].data_entrada);
        tdDe.appendChild(data_eD);
        var id2 = document.createAttribute("id");
        id2.value = "data_entrada" + obj[item].id_hotel;
        tdDe.setAttributeNode(id2);

        var tdDs = document.createElement("td");
        var data_sD = document.createTextNode(obj[item].data_saida);
        tdDs.appendChild(data_sD);
        var id3 = document.createAttribute("id");
        id3.value = "data_saida" + obj[item].id_hotel;
        tdDs.setAttributeNode(id3);

        var tdP = document.createElement("td");
        var precoD = document.createTextNode(obj[item].preco);
        tdP.appendChild(precoD);
        var id4 = document.createAttribute("id");
        id4.value = "preco" + obj[item].id_hotel;
        tdP.setAttributeNode(id4);

        var tdQq = document.createElement("td");
        var inputQ = document.createElement("input");
        var type = document.createAttribute("type");
        var max = document.createAttribute("max");
        var min = document.createAttribute("min");
        var value = document.createAttribute("value");
        type.value = "number";
        max.value = obj[item].quantidade_quartos;
        min.value = 1;
        value.value = 1;
        inputQ.setAttributeNode(value);
        inputQ.setAttributeNode(max);
        inputQ.setAttributeNode(min);
        inputQ.setAttributeNode(type);
        tdQq.appendChild(inputQ);
        var id5 = document.createAttribute("id");
        id5.value = "qtd_quartos" + obj[item].id_hotel;
        inputQ.setAttributeNode(id5);

        var tdQh = document.createElement("td");
        var qtd_hD = document.createTextNode(obj[item].quantidade_hospedes);
        tdQh.appendChild(qtd_hD);
        var id6 = document.createAttribute("id");
        id6.value = "qtd_hospedes" + obj[item].id_hotel;
        tdQh.setAttributeNode(id6);

        var buttonAd = document.createElement("button");
        var adicionar = document.createTextNode("Adicionar");
        var action = document.createAttribute("onclick");
        action.value = "addCarrinhoHotel(" + obj[item].id_hotel + ")";
        buttonAd.setAttributeNode(action);
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
    info.value = "danger";
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
        var inputQ = document.createElement("input");
        var type = document.createAttribute("type");
        var max = document.createAttribute("max");
        var min = document.createAttribute("min");
        var value = document.createAttribute("value");
        type.value = "number";
        max.value = obj[item].quantidade_passagens;
        min.value = 1;
        value.value = 1;
        inputQ.setAttributeNode(value);
        inputQ.setAttributeNode(max);
        inputQ.setAttributeNode(min);
        inputQ.setAttributeNode(type);
        tdQp.appendChild(inputQ);
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

function addCarrinhoHotel(id) {

    var verificarDuplicidade = percorrerCarrinhoHotel(id);

    if (verificarDuplicidade === true) {

        var nome = document.getElementById("nome" + id).innerText;
        var data_entrada = document.getElementById("data_entrada" + id).innerText;
        var data_saida = document.getElementById("data_saida" + id).innerText;
        var qtd_quartos = document.getElementById("qtd_quartos" + id).value;
        var qtd_hospedes = document.getElementById("qtd_hospedes" + id).innerText;
        var preco = document.getElementById("preco" + id).innerText;

        var totalPreco = document.getElementById("total");

        var totalConvertido = parseFloat(totalPreco.innerText);

        totalPreco.innerText = totalConvertido + (parseFloat(preco) * qtd_quartos);

        var carrinho = document.getElementById("carrinho");

        var tr = document.createElement("tr");
        var name0 = document.createAttribute("name");
        name0.value = id;
        tr.setAttributeNode(name0);

        var idTag = document.createAttribute("id");
        idTag.value = id;
        tr.setAttributeNode(idTag);

        var tdN = document.createElement("td");
        var nomeD = document.createTextNode(nome);
        tdN.appendChild(nomeD);
        var name1 = document.createAttribute("name");
        name1.value = "nome";
        tdN.setAttributeNode(name1);

        var tdDe = document.createElement("td");
        var data_entradaD = document.createTextNode(data_entrada);
        tdDe.appendChild(data_entradaD);
        var name2 = document.createAttribute("name");
        name2.value = "data_entrada";
        tdDe.setAttributeNode(name2);

        var tdDs = document.createElement("td");
        var data_saidaD = document.createTextNode(data_saida);
        tdDs.appendChild(data_saidaD);
        var name3 = document.createAttribute("name");
        name3.value = "data_saida";
        tdDs.setAttributeNode(name3);

        var tdP = document.createElement("td");
        var precoD = document.createTextNode(preco);
        tdP.appendChild(precoD);
        var name6 = document.createAttribute("name");
        name6.value = "preco";
        tdP.setAttributeNode(name6);

        var tdQt = document.createElement("td");
        var inputQ = document.createElement("input");
        var type = document.createAttribute("type");
        var max = document.createAttribute("max");
        var min = document.createAttribute("min");
        var idH = document.createAttribute("id");
        var actionPreco = document.createAttribute("onclick");
        var actionPreco2 = document.createAttribute("onkeyup");
        var actionPreco3 = document.createAttribute("onkeypress");
        var actionPreco4 = document.createAttribute("onkeydown");
        actionPreco2.value = "manterPreco_Hotel(" + id + "," + qtd_quartos + ")";
        actionPreco3.value = "manterPreco_Hotel(" + id + "," + qtd_quartos + ")";
        actionPreco4.value = "manterPreco_Hotel(" + id + "," + qtd_quartos + ")";
        idH.value = id + "inputH";
        inputQ.setAttributeNode(idH);
        actionPreco.value = "atualizarPreco_Hotel(" + id + "," + qtd_quartos + ")";
        type.value = "number";
        max.value = document.getElementById("qtd_quartos" + id).max;
        min.value = 1;
        inputQ.setAttributeNode(actionPreco);
        inputQ.setAttributeNode(actionPreco2);
        inputQ.setAttributeNode(actionPreco3);
        inputQ.setAttributeNode(actionPreco4);
        inputQ.setAttributeNode(max);
        inputQ.setAttributeNode(min);
        inputQ.setAttributeNode(type);
        inputQ.value = (qtd_quartos);
        tdQt.appendChild(inputQ);
        var name4 = document.createAttribute("name");
        name4.value = "qtd_quartos";
        tdQt.setAttributeNode(name4);

        var tdQh = document.createElement("td");
        var qtd_qhD = document.createTextNode(qtd_hospedes);
        tdQh.appendChild(qtd_qhD);
        var name5 = document.createAttribute("name");
        name5.value = "qtd_hospedes";
        tdQh.setAttributeNode(name5);

        var buttonR = document.createElement("button");
        var remover = document.createTextNode("Remover");
        var action = document.createAttribute("onclick");
        action.value = "excluirCarrinhoHotel(" + id + ")";
        buttonR.setAttributeNode(action);
        buttonR.appendChild(remover);

        tr.appendChild(tdN);
        tr.appendChild(tdDe);
        tr.appendChild(tdDs);
        tr.appendChild(tdP);
        tr.appendChild(tdQt);
        tr.appendChild(tdQh);
        tr.appendChild(buttonR);

        carrinho.appendChild(tr);

    }

}

function addCarrinhoVoo(id) {

    var verificarDuplicidade = percorrerCarrinhoVoo(id);

    if (verificarDuplicidade === true) {

        var origem = document.getElementById("origem" + id).innerText;
        var destino = document.getElementById("destino" + id).innerText;
        var data_ida = document.getElementById("data_i" + id).innerText;
        var data_volta = document.getElementById("data_v" + id).innerText;
        var quantidade_passagens = document.getElementById("qtd_p" + id).firstChild.value;
        var preco = document.getElementById("preco" + id).innerText;

        var totalPreco = document.getElementById("total");

        var totalConvertido = parseFloat(totalPreco.innerText);

        totalPreco.innerText = totalConvertido + parseFloat(preco);

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
        var inputQ = document.createElement("input");
        var type = document.createAttribute("type");
        var max = document.createAttribute("max");
        var min = document.createAttribute("min");
        var idV = document.createAttribute("id");
        var actionPreco = document.createAttribute("onclick");
        var actionPreco2 = document.createAttribute("onkeyup");
        var actionPreco3 = document.createAttribute("onkeypress");
        var actionPreco4 = document.createAttribute("onkeydown");
        actionPreco.value = "atualizarPreco_Voo(" + id + "," + quantidade_passagens + ")";
        actionPreco2.value = "manterPreco_Voo(" + id + "," + quantidade_passagens + ")";
        actionPreco3.value = "manterPreco_Voo(" + id + "," + quantidade_passagens + ")";
        actionPreco4.value = "manterPreco_Voo(" + id + "," + quantidade_passagens + ")";
        type.value = "number";
        max.value = document.getElementById("qtd_p" + id).firstChild.max;
        min.value = 1;
        idV.value = id + "inputV";
        inputQ.setAttributeNode(idV);
        inputQ.setAttributeNode(actionPreco);
        inputQ.setAttributeNode(actionPreco2);
        inputQ.setAttributeNode(actionPreco3);
        inputQ.setAttributeNode(actionPreco4);
        inputQ.setAttributeNode(max);
        inputQ.setAttributeNode(min);
        inputQ.setAttributeNode(type);
        inputQ.value = (quantidade_passagens);
        tdQp.appendChild(inputQ);
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
        var action = document.createAttribute("onclick");
        action.value = "excluirCarrinhoVoo(" + id + ")";
        buttonR.setAttributeNode(action);
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

function manterPreco_Voo(id, quantidade) {

    var input = document.getElementById(id + "inputV");
    input.value = quantidade;

}

function manterPreco_Hotel(id, quantidade) {

    var input = document.getElementById(id + "inputH");
    input.value = quantidade;

}

function percorrerCarrinhoVoo(id) {

    var table = document.getElementById("carrinho2");

    var tamanho = table.rows.length;

    for (var i = 0; i < tamanho; i++) {

        if (table.rows[i].id == id) {

            return false;

        }

    }

    return true;

}

function percorrerCarrinhoHotel(id) {

    var table = document.getElementById("carrinho");

    var tamanho = table.rows.length;

    for (var i = 0; i < tamanho; i++) {

        if (table.rows[i].id == id) {

            return false;

        }

    }

    return true;

}

function excluirCarrinhoVoo(id) {

    var totalPreco = document.getElementById("total");

    var totalConvertido = parseFloat(totalPreco.innerText);

    var table = document.getElementById("carrinho2");

    var tamanho = table.rows.length;

    for (var i = 0; i < tamanho; i++) {

        if (table.rows[i].id == id) {

            var preco = parseFloat(table.rows[i].children[5].innerText);

            var quantidade = table.rows[i].children[4].firstChild.value;

            var c = totalConvertido - (preco * quantidade);

            totalPreco.innerText = parseFloat(c.toFixed(2));

            table.deleteRow(i);

        }

    }

}

function excluirCarrinhoHotel(id) {

    var totalPreco = document.getElementById("total");

    var totalConvertido = parseFloat(totalPreco.innerText);

    var table = document.getElementById("carrinho");

    var tamanho = table.rows.length;

    for (var i = 0; i < tamanho; i++) {

        if (table.rows[i].id == id) {

            var preco = parseFloat(table.rows[i].children[3].innerText);

            var quantidade = table.rows[i].children[4].firstChild.value;

            var c = totalConvertido - (preco * quantidade);

            totalPreco.innerText = parseFloat(c.toFixed(2));

            table.deleteRow(i);

        }

    }

}

function atualizarPreco_Hotel(id, quantidade) {

    var totalPreco = document.getElementById("total");

    var totalConvertido = parseFloat(totalPreco.innerText);

    var table = document.getElementById("carrinho");

    var tamanho = table.rows.length;

    for (var i = 0; i < tamanho; i++) {

        if (table.rows[i].id == id) {

            var preco = parseFloat(table.rows[i].children[3].innerText);

            var quantidadeAtualizada = table.rows[i].children[4].firstChild.value;

            var c = totalConvertido - (preco * quantidade);

            var preCalculo = parseFloat(c.toFixed(2));

            var c2 = preCalculo + (preco * quantidadeAtualizada);

            totalPreco.innerText = parseFloat(c2.toFixed(2));

            var maximo = table.rows[i].children[4].firstChild.max;

            table.rows[i].children[4].removeChild(table.rows[i].children[4].firstChild);

            var inputQ = document.createElement("input");
            var type = document.createAttribute("type");
            var max = document.createAttribute("max");
            var min = document.createAttribute("min");
            var actionPreco = document.createAttribute("onclick");
            actionPreco.value = "atualizarPreco_Hotel(" + id + "," + quantidadeAtualizada + ")";
            type.value = "number";
            max.value = maximo;
            min.value = 1;
            var idH = document.createAttribute("id");
            var actionPreco = document.createAttribute("onclick");
            var actionPreco2 = document.createAttribute("onkeyup");
            var actionPreco3 = document.createAttribute("onkeypress");
            var actionPreco4 = document.createAttribute("onkeydown");
            actionPreco2.value = "manterPreco_Hotel(" + id + "," + quantidadeAtualizada + ")";
            actionPreco3.value = "manterPreco_Hotel(" + id + "," + quantidadeAtualizada + ")";
            actionPreco4.value = "manterPreco_Hotel(" + id + "," + quantidadeAtualizada + ")";
            idH.value = id + "inputH";
            inputQ.setAttributeNode(idH);
            inputQ.setAttributeNode(actionPreco);
            inputQ.setAttributeNode(actionPreco2);
            inputQ.setAttributeNode(actionPreco3);
            inputQ.setAttributeNode(actionPreco4);
            inputQ.setAttributeNode(max);
            inputQ.setAttributeNode(min);
            inputQ.setAttributeNode(type);
            inputQ.value = (quantidadeAtualizada);
            table.rows[i].children[4].appendChild(inputQ);
            var id5 = document.createAttribute("id");
            id5.value = "qtd_quartos" + id;
            inputQ.setAttributeNode(id5);

        }

    }

}

function atualizarPreco_Voo(id, quantidade) {

    var totalPreco = document.getElementById("total");

    var totalConvertido = parseFloat(totalPreco.innerText);

    var table = document.getElementById("carrinho2");

    var tamanho = table.rows.length;
    for (var i = 0; i < tamanho; i++) {

        if (table.rows[i].id == id) {

            var preco = parseFloat(table.rows[i].children[5].innerText);

            var quantidadeAtualizada = table.rows[i].children[4].firstChild.value;

            var c = totalConvertido - (preco * quantidade);

            var preCalculo = parseFloat(c.toFixed(2));

            var c2 = preCalculo + (preco * quantidadeAtualizada);

            totalPreco.innerText = parseFloat(c2.toFixed(2));

            var maximo = table.rows[i].children[4].firstChild.max;

            table.rows[i].children[4].removeChild(table.rows[i].children[4].firstChild);

            var inputQ = document.createElement("input");
            var type = document.createAttribute("type");
            var max = document.createAttribute("max");
            var min = document.createAttribute("min");
            var idV = document.createAttribute("id");
            var actionPreco = document.createAttribute("onclick");
            actionPreco.value = "atualizarPreco_Voo(" + id + "," + quantidadeAtualizada + ")";
            type.value = "number";
            max.value = maximo;
            min.value = 1;
            var actionPreco2 = document.createAttribute("onkeyup");
            var actionPreco3 = document.createAttribute("onkeypress");
            var actionPreco4 = document.createAttribute("onkeydown");
            actionPreco2.value = "manterPreco_Voo(" + id + "," + quantidadeAtualizada + ")";
            actionPreco3.value = "manterPreco_Voo(" + id + "," + quantidadeAtualizada + ")";
            actionPreco4.value = "manterPreco_Voo(" + id + "," + quantidadeAtualizada + ")";
            idV.value = id + "inputV";
            inputQ.setAttributeNode(idV);
            inputQ.setAttributeNode(actionPreco4);
            inputQ.setAttributeNode(actionPreco3);
            inputQ.setAttributeNode(actionPreco2);
            inputQ.setAttributeNode(actionPreco);
            inputQ.setAttributeNode(max);
            inputQ.setAttributeNode(min);
            inputQ.setAttributeNode(type);
            inputQ.value = (quantidadeAtualizada);
            table.rows[i].children[4].appendChild(inputQ);
            var id5 = document.createAttribute("id");
            id5.value = "qtd_p" + id;
            inputQ.setAttributeNode(id5);

        }

    }

}

function venda() {

    var carrinho_hotel = document.getElementById("carrinho");
    var carrinho_voo = document.getElementById("carrinho2");
    var cpf = document.getElementById("cpf").innerText;
    var total = document.getElementById("total").innerText;

    var tamanho_hotel = carrinho_hotel.rows.length;
    var tamanho_voo = carrinho_voo.rows.length;

    var precoV = "";
    var precoH = "";
    var quantidadeVoo = "";
    var quantidadeHotel = "";
    var idsVoo = "";
    var idsHotel = "";

    for (var i = 0; i < tamanho_hotel; i++) {

        if (i + 1 != tamanho_hotel) {

            idsHotel += carrinho_hotel.rows[i].id + ",";
            precoH += carrinho_hotel.rows[i].children[3].innerText + ",";
            quantidadeHotel += carrinho_hotel.rows[i].children[4].firstChild.value + ",";

        } else {

            idsHotel += carrinho_hotel.rows[i].id;
            precoH += carrinho_hotel.rows[i].children[3].innerText;
            quantidadeHotel += carrinho_hotel.rows[i].children[4].firstChild.value;

        }

    }

    for (var i = 0; i < tamanho_voo; i++) {

        if (i + 1 != tamanho_voo) {

            idsVoo += carrinho_voo.rows[i].id + ",";
            precoV += carrinho_voo.rows[i].children[5].innerText + ",";
            quantidadeVoo += carrinho_voo.rows[i].children[4].firstChild.value + ",";

        } else {

            idsVoo += carrinho_voo.rows[i].id;
            precoV += carrinho_voo.rows[i].children[5].innerText;
            quantidadeVoo += carrinho_voo.rows[i].children[4].firstChild.value;

        }

    }

    window.location.href = "VendaServlet?"
            + "idsVoos="
            + idsVoo
            + "&idsHoteis="
            + idsHotel
            + "&precosVoos="
            + precoV
            + "&precosHoteis="
            + precoH
            + "&quantidadeVoos="
            + quantidadeVoo
            + "&quantidadeHoteis="
            + quantidadeHotel
            + "&cpf="
            + cpf
            + "&totalP="
            + total;

}