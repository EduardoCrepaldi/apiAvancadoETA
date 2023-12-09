package queries;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Languages {
    public static Response getLanguageQuery(String language, RequestSpecification requestSpec) {
        return given().
                spec(requestSpec).
                body("{\"query\":\"query {\\n  language(code: \\\""+language+"\\\")\\n {\\n        code\\n        name\\n        native\\n    }\\n}\",\"variables\":{}}").
                when().
                post();
    }
}
