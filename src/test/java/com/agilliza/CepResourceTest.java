package com.agilliza;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CepResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/cep/45836000")
          .then()
             .statusCode(200)
             .body(is("{\"bairro\":\"\",\"cep\":\"45836000\",\"cidade\":{\"codigoIbge\":2915601,\"ddd\":\"73\",\"id\":4514,\"nome\":\"Itamaraju\",\"uf\":\"BA\"},\"complemento\":\"\",\"descricao\":\"\",\"id\":529130,\"nome\":\"\",\"tipo\":\"\"}"));
    }

}