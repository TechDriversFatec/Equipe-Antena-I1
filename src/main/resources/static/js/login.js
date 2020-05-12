$(document).ready(function() {

  var login = document.getElementById('login');
  var cadastro = document.getElementById('cadastro');
  
  window.onclick = function(event) {
      if (event.target == login) {
          login.style.display = "none";
      }

      if (event.target == cadastro) {
          cadastro.style.display = "none";
      }
  }

  $('#cpf-cadastro').mask('000.000.000-00', {reverse: true});

});

function entrar() {
  const data = {
    email: document.getElementsByName("email-login")[0].value,
    senha: document.getElementsByName("senha-login")[0].value
  };
  Fetch.post("/empresario/login", data)
    .then(() => {
      window.location = "/empresa/painel";
      localStorage.setItem('email', data.email);
    })
    .catch(_ => {
      alert("Credenciais inválidas.");
    });
}


function abrePopupLogin(event) {
  event.preventDefault();
  document.getElementById('login').style.display='block';    
}

function fechaPopupLogin(event) {
  event.preventDefault();
  document.getElementById('login').style.display='none';    
}

function abrePopupCadastro(event) {
  event.preventDefault();
  document.getElementById('cadastro').style.display='block';    
}

function fechaPopupCadastro(event) {
  event.preventDefault();
  document.getElementById('cadastro').style.display='none';    
}