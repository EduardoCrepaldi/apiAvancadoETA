package queries;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class Countries {

    public static Response getCountryQuery(String country, RequestSpecification requestSpec) {
        return given().
                spec(requestSpec).
                body("{\"query\":\"query {\\n  country(code:\\\""+country+"\\\")\\n  {\\n    code\\n    name\\n    native\\n    phone\\n    languages\\n    {\\n        code\\n        name\\n    }\\n  }\\n}\",\"variables\":{}}").
                when().
                post();
    }
}