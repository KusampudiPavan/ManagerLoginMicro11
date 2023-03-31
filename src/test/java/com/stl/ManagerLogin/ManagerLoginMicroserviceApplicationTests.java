package com.stl.ManagerLogin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;


@SuppressWarnings("unused")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ManagerLoginMicroserviceApplicationTests {

    
    @Test
    @Order(2)
    public void testAdminLogin() {
        String jsonbody= "{\"email\" : \"hema@gmail.com\",\"password\" : \"hema\"}";
        String token=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .post("http://localhost:8083/Manager/authenticatetoken")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
   
}

