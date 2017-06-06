function confirmar() {

    document.getElementById('aceitacao').style.display = 'block';
    document.getElementById('formulario').style.display = 'none';
    
}

function exclusao(id, x) {

    var result = confirm("Deseja excluir mesmo?");

    if (result) {

        location.href = "Exclui" + x + "Servlet?action=delete&id=" + id;

    }

}