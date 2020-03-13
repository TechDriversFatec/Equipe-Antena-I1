package cadi.hello;

import org.bson.Document;
import org.junit.Assert;
import org.junit.Test;

public class ModelCadiTest {

    @Test
    public void insertCadiTest(){
        ModelCadi modelCadiTest = new ModelCadi("fongo");
        Document testDocument = new Document("cadi","usuarioCadiExemplo");

        Assert.assertEquals("[]",modelCadiTest.searchUsuario("cadi","usuarioCadiExemplo"));

        modelCadiTest.addCADI(testDocument);
        String found = modelCadiTest.searchUsuario("cadi","usuarioCadiExemplo");
        found = found.substring(1, found.length()-1);

        Assert.assertEquals(Document.parse(found).get("cadi"), "usuarioCadiExemplo");

        modelCadiTest.removeCADI(testDocument);
        Assert.assertEquals("[]",modelCadiTest.searchUsuario("cadi","usuarioCadiExemplo"));

    }

}
