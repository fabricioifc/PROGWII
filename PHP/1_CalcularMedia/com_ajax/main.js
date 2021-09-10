const botao = document.querySelector("#formulario");

botao.addEventListener("submit", function (event) {
  event.preventDefault();
  const form = this;

  fetch("calcular.php", {
    method: "POST",
    // headers: {
    //   Accept: "application/json",
    // },
    body: new FormData(form),
  })
    .then((response) => response.json()) //veja que a unica alteração foi aqui
    .then(function (json) {
      console.log(json);
      if (json.erro) {
        document.querySelector("div.mensagem").innerHTML = json.erro;
      } else {
        document.querySelector("div.mensagem").innerHTML = null;
        document.querySelector("#media").innerHTML = json.media;
        document.querySelector("#status").innerHTML = json.status[0];
        document.querySelector("#status").style.color = json.status[1];
      }
    });
});
