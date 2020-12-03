function calculo() {



    var num1 = (document.getElementById('data').value);

    var meses = new Array("ano", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro");

    var dia = num1.substring(8, 10);

    var ano = num1.substring(0, 4);

    var mes = num1.substring(5, 7);
    // window.alert(typeof mes);


    if (dia != "" && mes != "" && ano != "") {


        document.querySelector("div.resultados p.valor").innerHTML = `Data: ${dia} de ${meses[mes]} de ${ano}`;


    } else {

        document.querySelector("div.mensagens").innerHTML = "Digite data valida";
    }



}

function validar(datas) {
    if (datas != "") {


        return true;
    } else {

        window.alert('passou nda')
        return false;
    }

}

