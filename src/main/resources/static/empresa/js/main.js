(function() {

  let emailStorage = localStorage.getItem('email');


  let timeline = new Timeline('/atualizaProjeto');

  let maisInfoModal = $('#modal-mais-info');

  let defaultModel = {
    titulo: '',
    'descricao-breve': '',
    'descricao-completa': '',
    'descricao-tecnologias': '',
    'link-externo-1': '',
    'link-externo-2': '',
    fase: 0,
    reuniao: {
      data: '',
      horario: '',
      local: '',
      'datas-possiveis': []
    },
    status: {
      negado: false,
      motivo: ''
    },
    entregas: [],
    alunos: [],
    'responsavel-cadi': '',
    'responsavel-professor': [],
    'responsavel-empresario': ''
  };

  Fetch.get(`/empresario/byEmail/${emailStorage}`).then(empresario => {
    Fetch.get(`/projeto/byempresario/${empresario.email}`).then(projetos => {
      projetos.forEach(projeto => {
        console.log(projeto)
            let tr = $.parseHTML(`
            <tr data-project-item="${ projeto._id }">
              <th scope="row">${ projeto.titulo }</th>
              <td data-timeline-show></td>
              <td>
                <a href="#" data-toggle="modal" data-target="#modal-mais-info">Mais informações</a>
              </td>
            </tr>
          `);

         let $tr = $(tr);
         timeline.insertTimeline($tr.find('[data-timeline-show]').get(0), projeto);

        $('[data-projects-table-body]').append(tr);
      });
    });



  function insertProjectsOnTable(projecs) {
    
    

    projecs.forEach(projeto => {
      let tr = $.parseHTML(`
        <tr data-project-item="${ projeto._id }">
          <th scope="row">${ projeto.titulo }</th>
          <td data-timeline-show></td>
          <td>
            <a href="#" data-toggle="modal" data-target="#modal-mais-info">Mais informações</a>
          </td>
        </tr>
      `);

      let $tr = $(tr);

      $tr.click(function(e) {
        
        e.preventDefault();

        maisInfoModal.find('#modal-label').text(projeto.titulo);

        let pegaElemento = id => $(maisInfoModal.find(`#${id}`));

        let elements = [
          {
            element: pegaElemento('info-descricao-breve'),
            key: 'descricao-breve'
          },          
          {
            element: pegaElemento('info-descricao-completa'),
            key: 'descricao-completa'
          },
          {
            element: pegaElemento('info-descricao-tecnologias'),
            key: 'descricao-tecnologias'
          },
          {
            element: pegaElemento('info-links-externos'),
            key: '',
            excessao: true
          },
          {
            element: pegaElemento('info-link-externo-1'),
            key: 'link-externo-1'
          },
          {
            element: pegaElemento('info-link-externo-2'),
            key: 'link-externo-2'
          },
          {
            element: pegaElemento('info-responsavel-cadi'),
            key: 'responsavel-cadi'
          },
          {
            element: pegaElemento('info-professores-responsaveis'),
            key: 'responsavel-professor',
            excessao: true
          },
          {
            element: pegaElemento('info-reuniao'),
            key: 'reuniao',
            excessao: true
          },
          {
            element: pegaElemento('info-entregas'),
            key: 'entregas',
            excessao: true
          },
          {
            element: pegaElemento('info-negado'),
            key: 'status',
            excessao: true
          }
        ];

        elements.forEach(item => {

          let contentElement = item.element.find('[data-text-content]');

          if (item.key.indexOf('link-externo') != -1) {
            contentElement.attr('href', projeto[item.key]);
          }

          if (item.key && !item.excessao) {
            if (!projeto[item.key]) {
              item.element.addClass('d-none');
              return;
            }
            else {
              contentElement.text(projeto[item.key]);
            }
          }
          else if (!item.key) {
            if (!projeto['link-externo-1'] && !projeto['link-externo-2']) {
              item.element.addClass('d-none');
              return;
            }
          }
          else if (item.key === 'status') {
            if (!projeto.status.negado) {
              item.element.addClass('d-none');
              return;
            }
            else {
              contentElement.text(projeto.status.motivo);
            }
          }
          else if (item.key === 'reuniao') {
            let reuniao = projeto.reuniao;
            
            if (!reuniao.data && !reuniao.horario && !reuniao.local) {
              item.element.addClass('d-none');
              return;
            }
            else {
              contentElement.text(`${reuniao.data} - ${reuniao.horario} - ${reuniao.local}`);
            }
          }
          else if (item.key === 'entregas' || item.key ==='responsavel-professor') {
            
            if (!projeto[item.key].length) {
              item.element.addClass('d-none');
              return;
            }
            else {
              projeto[item.key].forEach(x => {
                contentElement.append($.parseHTML(`<li>${x}</li>`));
              });
            }
          }
        });
      });

      timeline.insertTimeline($tr.find('[data-timeline-show]').get(0), projeto);

      tbody.append(tr);
    });
  }

  $('[data-publish-project]').click(function(e) {
    
    let formNewProject = $('[data-form-new-project]');
    let inputsData = formNewProject.serializeArray();
    let projeto = {
      ...defaultModel,
      fase: 1,
      'responsavel-empresario': empresario.email
    };

    inputsData.forEach(input => {
      projeto[input.name] = input.value; 
    });

    Fetch.post("/projeto/save", JSON.stringify(projeto)).then(() => {
      location.reload();
      /*const $form = document.getElementById("formulario");
      $form.reset();
      carregarTarefas();*/
    });

    // $.ajax({
    //   type: "POST",
    //   url: '/projeto/save',
    //   data: JSON.stringify(projeto),
    //   success: function() {
    //     location.reload();
    //   },
    //   dataType: 'json'
    // });
  });

  $('[data-empresario-logout]').click(function(e){

    e.preventDefault();

    localStorage.removeItem('token');
    location.replace('/');
  })

});
})();