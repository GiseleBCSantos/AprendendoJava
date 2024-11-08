function mostrarOpcoes(){
    var divs = document.querySelectorAll(".opcao_reserva");
    divs.forEach((div) => div.style.display = 'none')
    console.log(divs)

    var selected = document.querySelector('input[name="tipoReserva"]:checked');
    if (selected){
        var divId = selected.value;
        document.getElementById(divId).style.display = 'block';
    }
}