package api;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.PropertyLoader;

import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class apiTest {
    String baseUrl;
    String path;
    static final String TOKEN = "Bearer 1aa830ea04f7515c7c755049be1743dcc7b1c4f2";

    @BeforeClass
    public void setUp(){
        baseUrl = PropertyLoader.getProperty("apiBaseUrl");
        path = "/rest/v1/projects";
    }

    @Test
    public void getAll(){
        List<Long> id =
        given()
                .baseUri(baseUrl)
                .header("Authorization", TOKEN)
        .when()
                .get(path)
        .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("id");


        System.out.println(id.get(0));

        Project p1 =
        given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .header("Authorization", TOKEN)
                .when()
                .get(path+"/"+id.get(3).toString())
                .then().statusCode(200)
        .extract().as(Project.class);


        System.out.println(p1.getId());
        System.out.println(p1.getColor());
        System.out.println(p1.getUrl());

    }

    @Test
    public void createProject(){

        Project create = new Project(65, "Object");

        Project p1 =
                given()
                        .baseUri(baseUrl)
                        .header("Authorization", TOKEN)
                        .header("X-Request-Id", UUID.randomUUID())
                        .contentType("application/json")
                        .when()
                        .body("{\n" +
                                "    \"name\":\"Object\"\n" +
                                "}")
                        .post(path)
                        .then().statusCode(200)
                        .extract().as(Project.class);


        System.out.println(p1.getId());
        System.out.println(p1.getColor());
        System.out.println(p1.getUrl());
    }
}
