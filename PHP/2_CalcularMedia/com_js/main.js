function verificarStatus(media) {
  if (media < 4) {
    return "Reprovado";
  } else if (media >= 7) {
    return "Aprovado";
  }
  return "Em Exame";
}

function calcularMedia(nota1, nota2) {
  return (parseFloat(nota1) + parseFloat(nota2)) / 2;
}

function validar(nota1, nota2) {
  if (isNaN(nota1) || isNaN(nota2)) {
    return "Informe notas válidas!";
  }
  return null;
}

const botao = document.querySelector("#formulario");

botao.addEventListener("submit", function (event) {
  event.preventDefault();

  let nota1 = this.nota1.value.replace(",", ".");
  let nota2 = this.nota2.value.replace(",", ".");

  let erro = validar(nota1, nota2);

  if (erro) {
    document.querySelector("div.mensagem").innerHTML = erro;
  } else {
    let media = calcularMedia(nota1, nota2);
    let status = verificarStatus(media);
    document.querySelector("#media").innerHTML = media;
    document.querySelector("#status").innerHTML = status;
  }
});
