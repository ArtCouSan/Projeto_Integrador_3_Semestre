function pesquisar() {
    var inicio = document.querySelector("#inicio").value;
    var fim = document.querySelector("#fim").value;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.addEventListener("load", listar);
    xmlhttp.open("GET", "BuscarRelatorio?inicio=" + inicio + "&fim=" + fim);
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
        var funcionarioD = document.createTextNode(obj[item].funcionario);
        tdF.appendChild(funcionarioD);
        var id1 = document.createAttribute("id");
        id1.value = obj[item].id_venda;
        tdF.setAttributeNode(id1);

        var tdC = document.createElement("td");
        var clienteD = document.createTextNode(obj[item].cliente);
        tdC.appendChild(clienteD);
        var id2 = document.createAttribute("id");
        id2.value = obj[item].id_venda;
        tdC.setAttributeNode(id2);

        var preco = parseFloat(obj[item].preco.toFixed(2));

        var tdT = document.createElement("td");
        var total_pD = document.createTextNode(preco);
        tdT.appendChild(total_pD);
        var id3 = document.createAttribute("id");
        id3.value = obj[item].id_venda;
        tdT.setAttributeNode(id3);

        var tdD = document.createElement("td");
        var data_D = document.createTextNode(obj[item].data);
        tdD.appendChild(data_D);
        var id4 = document.createAttribute("id");
        id4.value = obj[item].id_venda;
        tdD.setAttributeNode(id4);

        var tdFi = document.createElement("td");
        var filial = document.createTextNode(obj[item].filial);
        tdFi.appendChild(filial);
        var id5 = document.createAttribute("id");
        id5.value = obj[item].id_venda;
        tdFi.setAttributeNode(id5);

        tr2.appendChild(tdD);
        tr2.appendChild(tdFi);
        tr2.appendChild(tdC);
        tr2.appendChild(tdF);
        tr2.appendChild(tdT);

        table.appendChild(tr2);

    }

}