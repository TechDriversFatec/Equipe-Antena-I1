$(document).ready(function () {

	document.getElementById('cadastro').style.display = 'none';

	//let email = sessionStorage.getItem("sess_email_aluno");
	let tela = document.querySelector('#tabela-projetos');
	let telaemail = document.getElementById('bodyemail');
	let rota = "/projetos"
	let retorno = {}

	/* Pegando os dados do aluno logado */
	Fetch.get(`/aluno/byID`).then(aluno => {
		console.log(aluno)
		Fetch.get(`/projeto/byaluno/${aluno.email}`).then(projetos => {
			console.log(projetos);
		});

	});

	$.get(rota, function (projetosBE, err) {
		
		let projects = JSON.parse(projetosBE);
		let wichParticipate = [];
		for (i = 0; i < projects.length; i++) {
			isParticipate = projects[i].alunos.find(aluno => aluno == email)
			if (isParticipate) {
				wichParticipate.push(i);
			}
		}
		if (wichParticipate) {
			wichParticipate.map((index) => {
				console.log(index);
				var $tela = document.querySelector('#tpjr'),
					HTMLTemporario = $tela.innerHTML,
					HTMLNovo = "<tr> <th>" + projects[index].chave + "</th>"
						+ "<th>" + projects[index].titulo + "</th>" + "<th>"
						+ projects[index].fase + "</th>"
						+ `<th><button onclick="abrePopupEntregar(event,chave='${projects[index].chave}')">Entregar</button></th>`
						+ "</tr>";
				HTMLTemporario = HTMLTemporario + HTMLNovo;
				$tela.innerHTML = HTMLTemporario;
			});
		}
	});

	$('#botao-add').click(function () {
		let codigoProjeto = $("#codigo-projetoLabel").val();
		Fetch.get(`/projeto/bychave/${codigoProjeto}`).then(projeto => {
			projeto = {"chave":codigoProjeto};
			console.log(projeto)
			Fetch.post("/projeto/update", projeto).then(() => {
			  
			});
		});

	});

	function abrePopupLogin(event) {
		event.preventDefault();
		document.getElementById('login').style.display = 'block';
	}

	function fechaPopupLogin(event) {
		event.preventDefault();
		document.getElementById('login').style.display = 'none';
	}

});	