# Projeto Antenas

- Jean Pierro
- Jéssica Rosado
- Marcelo Teixeira
- Rodrigo Prado
- Rone Bento

## Entregas
Issues da primeira entrega:\
https://gitlab.com/jesscahelen/antenas-integracao/-/issues/1 \
https://gitlab.com/jesscahelen/antenas-integracao/-/issues/2 \
https://gitlab.com/jesscahelen/antenas-integracao/-/issues/3 \
https://gitlab.com/jesscahelen/antenas-integracao/-/issues/5 \
\
Issues da segunda entrega: \
https://gitlab.com/jesscahelen/antenas-integracao/-/issues/4 \
https://gitlab.com/jesscahelen/antenas-integracao/-/issues/10 \
https://gitlab.com/jesscahelen/antenas-integracao/-/issues/12 \
https://gitlab.com/jesscahelen/antenas-integracao/-/issues/15 \
https://gitlab.com/jesscahelen/antenas-integracao/-/issues/16 \
https://gitlab.com/jesscahelen/antenas-integracao/-/issues/17 

Issues da terceira entrega: \
https://gitlab.com/jesscahelen/antenas-integracao/-/issues/25

## Refatoração do Código


Com base no código gerado em Padrões de Projeto onde foi utilizado com framework [Java Spark](http://sparkjava.com/), foi necessário realizar a refatoração, tendo em vista implementar melhorias no quesito segurança, modularidade e encapsulamento do sistema, analisando código original não atendia os requisitos não funcionais do sistema de forma adequada.
Pensando nisso, realizamos a refatoração do código no framework [Spring Boot](https://spring.io/projects/spring-boot), até o momento foi [reestruturado as rotas](https://gitlab.com/jesscahelen/antenas-integracao/-/issues/15 "Link para Issue") e [implementado os requisitos de segurança da API](https://gitlab.com/jesscahelen/antenas-integracao/-/issues/16 "Link para Issue") (Filter de requisição, Cookie, Token JWT) Baseado no Spring Boot Security.
\
\
O pipeline de CI/CD também foi adaptado para a utilização do framework Spring Boot e a ferramenta de gerenciamento de projetos [Apache Maven](https://maven.apache.org/). [Link para a issue](https://gitlab.com/jesscahelen/antenas-integracao/-/issues/17).

## Testes

Na fase atual do projeto, são realizados [testes de integração](https://gitlab.com/jesscahelen/antenas-integracao/-/commit/4f894498bb7a7e4cf75a2cd1e0c133cbbb4e3825 "Link para o commit") com o banco Mongo Atlas que utilizam os frameworks JUnit 5 e SpringBootTest, baseados no modelo refatorado com base no framework Spring Boot. [Link para a issue](https://gitlab.com/jesscahelen/antenas-integracao/-/issues/2).
Após a realização dos testes, é gerado um relatório de cobertura baseado na biblioteca [JaCoCo](https://www.eclemma.org/jacoco/). [Link para a issue](https://gitlab.com/jesscahelen/antenas-integracao/-/issues/10).

## Gitlab

Foi escolhido Gitlab, um repositório baseado em git, possui várias ferramentas que utilizaremos para outros pontos, e tem bastante implementação com várias ferramentas.
Utilizamos o Gitlab para:
- Gerenciamento de Controle de Fonte
- Continuous Integration com o Gitlab CI
- BurnDown com as [Issues](https://gitlab.com/jesscahelen/antenas-integracao/-/issues "Issues") e [Boards Kanban](https://gitlab.com/jesscahelen/antenas-integracao/-/boards "Boards")

## Google Cloud

Para o deploy da aplicação em nuvem, utilizaremos o [Google Cloud](https://cloud.google.com), Devido a sua compatibilidade com o Gitlab, facilidade na configuração da VM de acordo com as necessidades do projeto, sua documentação detalhada, crédito inicial e estimativa de custos.
\
Até o momento uma vm foi inicializada e configurada juntamente com a configuração do Runner conectando assim o cloud ao Gitlab. [Link para Issue](https://gitlab.com/jesscahelen/antenas-integracao/-/issues/3)


## CI / CD

 Para a parte de Integração Contínua e Deploy Contínuo utilizaremos o GitLab CI, uma ferramenta disponibilizada pelo GitLab para desenvolvimento de Software através de metodologias contínuas, por fazer parte do time das ferramentas disponibilizadas pelo GitLab e pelo seu set de [recursos disponíveis](https://docs.gitlab.com/ee/ci/#feature-set), de fácil configuração, que auxiliam no processo de DevOps. [Link para Issue relacionada ao arquivo gitlab-ci](https://gitlab.com/jesscahelen/antenas-integracao/-/issues/5).
 \
 \
 As fases de CI do projeto são compostas por:
- Realização de testes unitários e de integração gerenciados pela ferramenta Maven.
- Compilação do código (fase de 'build') através da ferramenta Maven.
- Geração de uma imagem docker utilizando o projeto compilado e upload dela para o repositório projetoantenas/antenas-integracao. [Link para a issue](https://gitlab.com/jesscahelen/antenas-integracao/-/issues/17).

A fase de CD do projeto será composta por:
- Execução do aplicativo como imagem de um contêiner Docker em um cluster do Google Kubernetes Engine.
- Garantir o Deploy Contínuo com o [mecanismo de atualização gradual do GKE](https://cloud.google.com/kubernetes-engine/docs/tutorials/hello-app#step_8_deploy_a_new_version_of_your_app).

## MongoDB Atlas

Para o banco de dados, utilizaremos o [MongoDB Atlas](https://www.mongodb.com/cloud/atlas), para ter uma segurança a mais que o banco de dados estará disponível, já que estará na Cloud do MongoDB, facilitando também o acesso dos integrantes da equipe e não sobrecarregando menos a máquina virtual em que o aplicativo estará disponível. [Link para Issue](https://gitlab.com/jesscahelen/antenas-integracao/-/issues/4).
\
No momento o banco está mapeado para testes e para produção, falta verificar sobre backup nessa interface em específico.


## Sonarqube Cloud

Para o Monitoramento do App foi escolhido o [Sonarqube Cloud](https://sonarcloud.io/), pois, possui várias métricas e relatórios de bugs, integração com [Jacoco](https://mvnrepository.com/artifact/org.jacoco/jacoco-maven-plugin) para cobertura de código e integração com Gitlab para que o repositório seja sincronizado. Auxilia a configuração que tem passos manuais e tem a disponibilidade de utilizar sem a necessidade de também sobrecarregar mais nossa máquina virtual e manter disponível o acesso dos dados por todos envolvidos no projeto. [Link para Issue](https://gitlab.com/jesscahelen/antenas-integracao/-/issues/25).
O Sonarqube é um job do nosso CI, e ele é realizado sempre que há um commit na branch master.
E está disponível para consulta: [Sonarqube Cloud - Projeto Antenas](https://sonarcloud.io/dashboard?id=jesscahelen_antenas-integracao)