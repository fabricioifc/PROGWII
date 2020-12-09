

const alunos = ['Roberto', 'Denilson', 'pedro']

document.querySelector("div.resultados").innerHTML += alunos.sort();

document.querySelector("div.resultados").innerHTML += "<hr />"

alunos.push('ana');

document.querySelector("div.resultados").innerHTML += alunos.sort();
document.querySelector("div.resultados").innerHTML += "<hr />"

document.querySelector("div.resultados").innerHTML += alunos.length;
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