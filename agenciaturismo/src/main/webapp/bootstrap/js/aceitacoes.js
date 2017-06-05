function confirmar(pergunta) {

    var result = confirm("Deseja " + pergunta + " mesmo?");

    return result;

}

function exclusao(id, x) {

    var result = confirm("Deseja excluir mesmo?");

    if (result) {

        location.href = "Exclui" + x + "Servlet?action=delete&id=" + id;

    }

}