package empresario.hello;

import aluno.hello.ModelAluno;
import antena.utils.MongoConnector;
import cadi.hello.ModelCadi;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import professor.hello.ModelProfessor;

import java.util.ArrayList;
import java.util.List;

public class ModelTest {

    MongoDatabase testDb = MongoConnector.connectToMongo("fongo", "test");

    private Model modelEmpresario = new Model(testDb);
    private ModelCadi modelCadi = new ModelCadi(testDb);
    private ModelAluno modelAluno = new ModelAluno(testDb);
    private ModelProfessor modelProfessor = new ModelProfessor(testDb);

    private Document projeto1 = Document.parse("{\"titulo\": \"Um projeto na fase 2\",\"descricao-breve\": \"Nesta fase o usuário tem que esperar uma avaliação detalhada\",\"descricao-completa\": \"\",\"descricao-tecnologias\": \"\",\"link-externo-1\": \"\",\"link-externo-2\": \"\",\"fase\": 2,\"reuniao\": {  \"data\": \"\",  \"horario\": \"\",  local: \"\",  \"datas-possiveis\": []},\"status\": {  \"negado\": false,  \"motivo\": \"\"},\"entregas\": [],\"alunos\": [],\"responsavel-cadi\": \"\",\"responsavel-professor\": [],\"responsavel-empresario\": \"flromeiroc@gmail.com\"}");
    private Document projeto2 = Document.parse("{'titulo' : 'Teste3', 'descricao-breve' : 'Teste descricao', 'descricao-completa' : 'Essa é a descrição completa', 'descricao-tecnologias' : 'Essa é a descrição de tecnologias', 'link-externo-1' : 'http://linkzao.com', 'link-externo-2' : 'http://linkzera.com', 'fase' : 4, 'reuniao' : { 'data' : '', 'horario' : '', 'local' : '', 'datas-possiveis' : [] }, 'status' : { 'negado' : false, 'motivo' : 'falta de informações' }, 'entregas' : [], 'alunos' : [], 'responsavel-cadi' : '', 'responsavel-professor' : [], 'responsavel-empresario' : 'teste@teste' }");
    private Document cadi1 = Document.parse("{'email':'rone@email.com','name':'John', 'senha':'11111', 'nivel':'1', 'ativo':true}");
    private Document empresario1 = Document.parse("{'email':'teste@teste', 'empresa':'Empresa Teste', 'telefone':'99999999'}");
    private Document professor1 = Document.parse("{'name':'Giuliano', 'email':'Giuliano@fatec.sp.gov.br', 'projeto-atribuido':'', 'senha':'1234', 'ativo':true, 'nivel':'1'}");
    private Document aluno1 = Document.parse("{'name':'Leticia', 'email':'leticia.carvalho11@fatec.sp.gov.br','senha':'123', 'ativo':true}");

    @Before
    public void inicializarModels(){

    }

    @Test
    public void integracaoTest1_addProjeto(){
        modelEmpresario.addProjeto(projeto1);
        Assert.assertEquals(modelEmpresario.getAllProjetos().first(),projeto1);
    }

    @Test
    public void integracaoTest2_addCadi(){
        modelCadi.addCADI(cadi1);
        Assert.assertEquals(Document.parse(modelCadi.listCadi().get(0)).get("email"), "rone@email.com");
    }

    @Test
    public void integracaoTest3_addEmpresario(){
        modelEmpresario.addEmpresario(empresario1);
        Assert.assertEquals(modelEmpresario.getAllEmpresarios().first(), empresario1);
    }

    @Test
    public void integracaoTest4_addProfessor(){
        modelProfessor.addProfessor(professor1);
        Assert.assertEquals(modelProfessor.listProfs().get(0),professor1 );
    }

    @Test
    public void integracaoTest5_addAluno(){
        modelAluno.addAluno(aluno1);
        Assert.assertEquals(Document.parse(modelAluno.listAlunos().get(0)).get("name"), "Leticia");
    }

    @Test
    public void integracaoTest6_adicionaFaseProjeto(){
        modelEmpresario.addProjeto(projeto1);
        Assert.assertEquals(modelEmpresario.getAllProjetos().first(),projeto1);
        Object idProj = modelEmpresario.getAllProjetos().first().get("_id");
        Document projFase2 = new Document("_id",idProj).append("fase","3");
        modelCadi.updateProjeto(projFase2);
        Assert.assertEquals(modelEmpresario.getAllProjetos().first().get("_id"), idProj);
        Assert.assertEquals(modelEmpresario.getAllProjetos().first().get("titulo"), "Um projeto na fase 2");
        Assert.assertEquals(modelEmpresario.getAllProjetos().first().get("fase"), "3");
    }

    @Test
    public void integracaoTest7_addProfProjeto(){
        modelEmpresario.addProjeto(projeto2);
        Assert.assertEquals(modelEmpresario.getAllProjetos().first(),projeto2);
        modelProfessor.addProfessor(professor1);
        Assert.assertEquals(modelProfessor.listProfs().get(0),professor1 );
        Object idProj = modelEmpresario.getAllProjetos().first().get("_id");
        List<String> listProfs = new ArrayList<String>();
        listProfs.add(professor1.toJson());
        Document projProf = new Document("_id",idProj).append("responsavel-professor", listProfs);
        modelCadi.updateProjeto(projProf);
        Assert.assertEquals(modelEmpresario.getAllProjetos().first().get("_id"), idProj);
        Assert.assertEquals(modelEmpresario.getAllProjetos().first().get("titulo"), "Teste3");
        Assert.assertEquals(modelEmpresario.getAllProjetos().first().get("responsavel-professor"), listProfs);
        Document emailProf = new Document("email", professor1.get("email"));
        Assert.assertEquals(modelProfessor.myProjects(emailProf).get(0).get("_id"), idProj);
        Assert.assertEquals(modelProfessor.myProjects(emailProf).get(0).get("titulo"), "Teste3");
    }

    @Test
    public void integracaoTest8_addAluno(){
        modelEmpresario.addProjeto(projeto2);
        Assert.assertEquals(modelEmpresario.getAllProjetos().first(),projeto2);
        modelAluno.addAluno(aluno1);
        Assert.assertEquals(Document.parse(modelAluno.listAlunos().get(0)).get("name"), "Leticia");
        Object idProj = modelEmpresario.getAllProjetos().filter(new Document ("titulo", "Teste3")).first().get("_id");
        modelAluno.atribuir(aluno1.get("email").toString(), idProj);
        List<String> listAlunos = new ArrayList<String>();
        listAlunos.add(aluno1.toJson());
        Assert.assertEquals(modelEmpresario.getAllProjetos().first().get("_id"), idProj);
        Assert.assertEquals(modelEmpresario.getAllProjetos().first().get("titulo"), "Teste3");
        Assert.assertEquals(modelEmpresario.getAllProjetos().first().get("alunos"), aluno1.get("email"));
    }


    @Test
    public void limpaColecoes(){
        modelCadi.limpaColecoes();
    }






}
