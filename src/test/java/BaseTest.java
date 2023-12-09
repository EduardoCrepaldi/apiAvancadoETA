import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
    public final RequestSpecification requestSpec = new RequestSpecBuilder()
            .addHeader("Content-Type", "application/json")
            .setBaseUri("https://countries.trevorblades.com/").build();
}