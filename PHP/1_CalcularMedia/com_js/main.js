function verificarStatus(media) {
  if (media < 4) {
    return "Reprovado";
  } else if (media >= 7) {
    return "Aprovado";
  }
  return "Em Exame";
}

function calcularMedia(form) {
  let nota1 = parseFloat(form.nota1.value);
  let nota2 = parseFloat(form.nota2.value);

  return (nota1 + nota2) / 2;
}

function validar(form) {
  if (form.nota1.value && form.nota2.value) {
    return null;
  }
  return "Informe notas válidas!";
}

const botao = document.querySelector("#formulario");

botao.addEventListener("submit", function (event) {
  event.preventDefault();

  let erro = validar(this);

  if (erro) {
    document.querySelector("div.mensagem").innerHTML = erro;
  } else {
    let media = calcularMedia(this);
    let status = verificarStatus(media);
    document.querySelector("#media").innerHTML = media;
    document.querySelector("#status").innerHTML = status;
  }
});
