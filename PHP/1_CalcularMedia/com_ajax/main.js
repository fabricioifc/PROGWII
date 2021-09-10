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
  const form = this;

  fetch("calcular.php", {
    method: "POST",
    headers: {
      Accept: "application/json",
    },
    body: new FormData(form),
  })
    .then((response) => response.json()) //veja que a unica alteração foi aqui
    .then(function (json) {
      // console.log(json);
      if (json.erro) {
        document.querySelector("div.mensagem").innerHTML = json.erro;
      } else {
        document.querySelector("#media").innerHTML = json.media;
        document.querySelector("#status").innerHTML = json.status;
      }
    });
});
