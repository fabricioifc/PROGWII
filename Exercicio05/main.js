function calculo() {


    var num = parseInt(document.getElementById('num1').value);

    var erro = "";

    if (validar(num)) {

        //var cont = contador(num)
        //document.querySelector("div.resultados p.contador").innerHTML = cont;
        setInterval(contador(num), 100);


        document.querySelector("div.mensagens").innerHTML = erro;

    }
}

function contador(num) {
    //window.alert('deu boa boa');
    var numero = num;

    while (numero > 0) {

        document.querySelector("div.resultados p.contador").innerHTML = numero;
        numero -= 1;

    };

    return;
}

function validar(a) {
    var retorno = false;


    if (a >= 5 && a <= 15) {
        retorno = true
        // window.alert('deu boa');

    } else {
        window.alert('deu ruim');
        erro = "Valores devem estar entre 5 e 15";

        document.querySelector("div.mensagens").innerHTML = erro;
    }




    return retorno;
}


