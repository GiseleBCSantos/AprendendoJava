function mostrarOpcoes(){
	var divs = document.querySelectorAll(".conteudo");
	divs.forEach((div) => div.style.display = 'none')
	
	var selected = document.querySelector('input[name="esp_equip"]:checked');
	if (selected){
		var divId = selected.value;
		document.getElementById(divId).style.display = 'block';
	}
}