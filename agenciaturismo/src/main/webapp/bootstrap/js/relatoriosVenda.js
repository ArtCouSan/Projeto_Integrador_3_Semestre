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
        var funcionarioD = document.createTextNode(obj[item].id_funcionario);
        tdF.appendChild(funcionarioD);
        var id1 = document.createAttribute("id");
        id1.value = "funcionario" + obj[item].id_venda;
        tdF.setAttributeNode(id1);

        var tdC = document.createElement("td");
        var clienteD = document.createTextNode(obj[item].id_cliente);
        tdC.appendChild(clienteD);
        var id2 = document.createAttribute("id");
        id2.value = "cliente" + obj[item].id_venda;
        tdC.setAttributeNode(id2);

        var tdT = document.createElement("td");
        var total_pD = document.createTextNode(obj[item].total_preco);
        tdT.appendChild(total_pD);
        var id3 = document.createAttribute("id");
        id3.value = "total_preco" + obj[item].id_venda;
        tdT.setAttributeNode(id3);

        tr2.appendChild(tdF);
        tr2.appendChild(tdC);
        tr2.appendChild(tdT);
    }

    table.appendChild(tr2);

}