





function calculo() {

    var num1 = parseInt(document.getElementById('num1').value);
    var num2 = parseInt(document.getElementById('num2').value);
    var erro = "";

    if (validar(num1, num2)) {
        var soma = somar(num1, num2);
        var sub = subtrair(num1, num2);
        var mult = multiplicar(num1, num2);
        var div = dividir(num1, num2);
        var rest = resto(num1, num2);


        document.querySelector("div.resultados p.soma").innerHTML = "soma: " + soma;
        document.querySelector("div.resultados p.sub").innerHTML = "subtração: " + sub;
        document.querySelector("div.resultados p.mult").innerHTML = "multiplicação: " + mult;
        document.querySelector("div.resultados p.div").innerHTML = "divisão: " + div;
        document.querySelector("div.resultados p.resto").innerHTML = "resto: " + rest;
        document.querySelector("div.mensagens").innerHTML = erro;


    }




}


function validar(a, b) {
    var retorno = false;

    if (a >= b && a > 0 && b >= 0) {
        retorno = true
        erro = " ";

    } else {

        erro = "1º valor invalido , ou valores negativo";

        document.querySelector("div.mensagens").innerHTML = erro;
    }
    return retorno;
}



function somar(a, b) {

    return a + b;
};


function subtrair(a, b) {
    return a - b;
};

const multiplicar = function (a, b) {

    return a * b;
};


function dividir(a, b) {
    return a / b;
}

function resto(a, b) {

    return a % b;
}