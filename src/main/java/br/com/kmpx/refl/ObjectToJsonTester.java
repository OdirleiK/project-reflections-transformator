package br.com.kmpx.refl;

import br.com.kmpx.Pessoa;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ObjectToJsonTester {

    public static void main(String[] args) throws JsonProcessingException {
        Pessoa pessoa = new Pessoa(1, "TESTE", "12323");
        ObjectoToJson objectoToJson = new ObjectoToJson();
        System.out.println(objectoToJson.transform(pessoa));
    }
}
