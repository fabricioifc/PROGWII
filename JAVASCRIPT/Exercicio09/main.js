const animais_tag = document.querySelector('div.animais')
const resultado_tag = document.querySelector('div.resultados')

var animais = [
    { nome: "Butters", idade: 3, tipo: "cachorro" },
    { nome: "Lizzy", idade: 6, tipo: "cachorro" },
    { nome: "Red", idade: 1,tipo: "gato" },
    { nome: "Joey", idade: 3, tipo: "gato" }
]

addEventListener('load', function() {
    console.log(animais);
    animais_tag.innerHTML += '<h3>Meus Animais</h3>'
    animais.forEach(animal => {
        animais_tag.innerHTML += `<p>${animal.nome} - ${animal.idade} - ${animal.tipo}<p>`
    });
    animais_tag.innerHTML += "<hr />"
    
    // Continue a tarefa aqui...
    
})