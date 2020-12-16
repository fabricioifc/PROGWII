


const alunos = ['Roberto', 'Denilson', 'Carlos']

document.querySelector("div.resultados").innerHTML += alunos.sort();

document.querySelector("div.resultados").innerHTML += "<hr />"

alunos.push('Juca');

document.querySelector("div.resultados").innerHTML += "sort: " + alunos.sort();
document.querySelector("div.resultados").innerHTML += "<hr />"

document.querySelector("div.resultados").innerHTML += 'Tamanho array = ' + alunos.length;
document.querySelector("div.resultados").innerHTML += "<hr />"

document.querySelector("div.resultados").innerHTML += '2º elemento = ' + alunos[1];
document.querySelector("div.resultados").innerHTML += "<hr />"

alunos.forEach(function (aluno) {
    document.querySelector("div.resultados").innerHTML += aluno + " <br>";

})
document.querySelector("div.resultados").innerHTML += "<hr />"
const alunoMap = alunos.map(function (aluno) {

    return aluno.toUpperCase()
})


document.querySelector("div.resultados").innerHTML += alunoMap;
document.querySelector("div.resultados").innerHTML += "<hr />"

const alunosSlice = alunos.slice(1, 3)
document.querySelector("div.resultados").innerHTML += alunosSlice;