function calculo() {


    var numero = parseInt(document.getElementById('num1').value);

    var erro = "";

    if (validar(numero)) {



        var result = setInterval(function contador(numero) {
            //window.alert('deu boa boa');
            var valor;
            if (numero >= 0) {
                document.querySelector("div.resultados p.contador").innerHTML = numero;
                numero -= 1;

            };
            if (numero == 0) {
                document.querySelector("div.resultados p.contador").innerHTML = "boom";
            };
            return valor
        }, 100);



        document.querySelector("div.mensagens").innerHTML = erro;

    };




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

}
