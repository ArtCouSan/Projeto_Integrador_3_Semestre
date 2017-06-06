function feedback() {

    var texto = document.getElementById("mensagem").value;

    var tamanho = texto.length;

    var x = 1000 - tamanho;
    
    document.getElementById("texto").innerText = "Maximo 1000 caracteres - " + x;

}
