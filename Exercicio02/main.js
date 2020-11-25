/*1. Crie uma variável com um valor inteiro entre 0 e 10.
2. Imprima a tabuada do número no console do navegador web, utilizando `console.log()`
3. Agora, imprima novamente, mas utlizando algum tipo de loop *(while, for, ...)*/


const valor = 5;

console.log(valor, "x 1 =", valor * 1)
console.log(valor, "x 2 =", valor * 2)
console.log(valor, "x 3 =", valor * 3)
console.log(valor, "x 4 =", valor * 4)
console.log(valor, "x 5 =", valor * 5)
console.log(valor, "x 6 =", valor * 6)
console.log(valor, "x 7 =", valor * 7)
console.log(valor, "x 8 =", valor * 8)
console.log(valor, "x 9 =", valor * 9)
console.log(valor, "x 10 =", valor * 10)

console.log("Taboada do", valor)
for (i = 1; i <= 10; i++) {
    console.log(valor, "x", i, " =", valor * i);
} 