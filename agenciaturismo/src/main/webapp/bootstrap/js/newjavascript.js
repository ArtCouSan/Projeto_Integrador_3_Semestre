function campoCPF() {
    var digito = document.quertSelector(".cpf").value;
    if (digito.length % 3 === 0 && digito.length !== 9) {
        digito += ".";
    } else if (digito.length === 9) {
        digito += "/";
    }
}

function campoCEP() {
    var digito = document.quertSelector(".cep").value;
    if (digito.length === 5) {
        digito += "-";
    }
}

function campoTelefone() {
    var digito = document.quertSelector(".telefone").value;
    if (digito.length === 0) {
        digito += "(";
    } else if (digito.length === 4) {
        digito += ")";
    } else if (digito.length === 8) {
        digito += "-";
    }
}

function campoCelular() {
    var digito = document.quertSelector(".celular").value;
    if (digito.length === 0) {
        digito += "(";
    } else if (digito.length === 4) {
        digito += ")";
    } else if (digito.length === 9) {
        digito += "-";
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