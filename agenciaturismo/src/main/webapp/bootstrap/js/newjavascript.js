function campoCPF() {
    var digito = document.quertSelector(".cpf").value;
    if (digito.length % 3 === 0 && digito.length !== 9) {
        digito += ".";
    } else if (digito.length === 9) {
        digito += "/";
    }
}

function confirmarExclusao() {
    // utilizar window.confirm ()
    if (confirm("Deseja excluir mesmo?") === true) {

    } else {

    }
}

function confirmarAlterar() {
    // utilizar window.confirm ()
    if (confirm("Deseja alterar mesmo?") === true) {

    } else {

    }
}