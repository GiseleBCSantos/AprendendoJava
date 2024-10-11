function validar(){
	let nome = frmContato.nome.value;
	let telefone = frmContato.telefone.value;
	let email = frmContato.email.value;
	
	if (nome === "" || telefone == "" || email === ""){
		alert("Preencha todos os campos.")
	}
	else{
		document.forms["frmContato"].submit()
	}
	
}