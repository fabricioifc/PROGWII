const animais_tag = document.querySelector('div.animais')
const resultado_tag = document.querySelector('div.resultados')

var animais = [
    { nome: "Butters", idade: 3, tipo: "cachorro" },
    { nome: "Lizzy", idade: 6, tipo: "cachorro" },
    { nome: "Red", idade: 1, tipo: "gato" },
    { nome: "Joey", idade: 3, tipo: "gato" }
]

addEventListener('load', function () {
    console.log(animais);
    animais_tag.innerHTML += '<h3>Meus Animais</h3>'
    animais.forEach(animal => {
        animais_tag.innerHTML += `<p>${animal.nome} - ${animal.idade} - ${animal.tipo}<p>`
    });
    animais_tag.innerHTML += "<hr />"

    // Continue a tarefa aqui...

    animais.push({ nome: "bobo", idade: 3, tipo: "gato" });

    var idadeTotal = animais.reduce((sum, animal) => {
        return sum + animal.idade;
    }, 0);

    resultado_tag.innerHTML += '<h3>Idade Total dos animais</h3>'
    resultado_tag.innerHTML += `Idade total :${idadeTotal}`;

    resultado_tag.innerHTML += "<hr />"

    let cachorros = animais.filter((animal) => {
        return animal.tipo === 'cachorro';
    })



    resultado_tag.innerHTML += '<h3>Meus Cachorros</h3>'
    cachorros.forEach(animal => {
        resultado_tag.innerHTML += `<p>${animal.nome} - ${animal.idade} - ${animal.tipo}<p>`
    });

    resultado_tag.innerHTML += "<hr />"

    let dog = animais.filter((animal) => {
        return animal.tipo === 'cachorro';
    })

    dog.map((animal) => {
        return animal.idade *= 7;

    })

    resultado_tag.innerHTML += '<h3>Meus Cachorros com idade de gente</h3>'
    dog.forEach(animal => {
        resultado_tag.innerHTML += `<p>${animal.nome} - ${animal.idade} - ${animal.tipo}<p>`
    });
    resultado_tag.innerHTML += "<hr />"





})