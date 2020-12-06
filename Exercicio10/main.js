const tag = document.querySelector('input[name="temperatura"]')
const resultados = document.querySelector('div.resultados')

tag.addEventListener('blur', function (evento) {
    // Continue a tarefa aqui...



    var result = calcular(tag.value);
    resultados.innerHTML += '<h3>Temperarura em Fahrenheit</h3>';
    resultados.innerHTML += result + ' °F';
})


function calcular(temp) {

    var resultado = ((temp * 9 / 5) + 32);
    return resultado;

}