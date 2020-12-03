
function calculo() {

    var nome = document.getElementById('nome').value;
    var num1 = parseFloat(document.getElementById('num1').value);

    var erro = "";

    if (validar(num1) && verNome(nome)) {

        var situacao = validaSituacao(num1);

        var aumento = (situacao - num1);

        var porcento = (aumento / num1) * 100

        document.querySelector("div.resultados p.valor").innerHTML = `O aumento salarial do funcionário ${nome} 
        que recebia ${num1.toFixed(2)} foi de ${porcento} %, aumento de ${aumento.toFixed(2)} e agora passa a receber ${situacao}`;

        document.querySelector("div.mensagens").innerHTML = erro;


    }




}
function verNome(name) {
    var retorno = false;

    if (name.length == 0 || name.length < 3) {

        erro = "Digite nome do funcionario";

        document.querySelector("div.mensagens").innerHTML = erro;

    } else {
        retorno = true;
    }

    return retorno;
}

function validar(numero) {
    var retorno = false;
    //window.alert("x");

    if (numero > 0) {
        retorno = true


    } else {

        erro = "Valores negativo ou nulo";

        document.querySelector("div.mensagens").innerHTML = erro;
    }


    return retorno;
}


function validaSituacao(valor) {
    var situacao = null;

    if (valor < 980) {
        situacao = valor * 1.2
    }
    if (valor >= 980 && valor < 1300) {
        situacao = valor * 1.15
    }
    if (valor >= 1300 && valor < 1800) {
        situacao = valor * 1.1
    }

    if (valor >= 1800) {
        situacao = valor * 1.05
    }

    return situacao.toFixed(2);
};

