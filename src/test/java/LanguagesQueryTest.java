import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import queries.Languages;

import static org.hamcrest.Matchers.is;


public class LanguagesQueryTest extends BaseTest{

    @Test
    public void shouldReturnStatus200() {
        String country = "en";
        Response response = Languages.getLanguageQuery(country, requestSpec);
        
        response.then().
                assertThat().
                statusCode(200).body("data.country.code", is(country));
    }

    @DataProvider(name = "languages")
    public Object[][] languagesData(){
        // object => {code, name, native}
        return new Object[][]{
                {"ca", "Catalan", "Català"},
                {"de", "German", "Deutsch"},
                {"en", "English", "English"},
                {"es", "Spanish", "Español"},
                {"fr", "French", "Français"},
                {"ja", "Japanese", "日本語"},
                {"pt", "Portuguese", "Português"},
        };
    }

    @Test(dataProvider = "languages")
    public void shouldVerifyMultiplesCodeAndNameCountry(String code, String name, String languageNative) {
        Response response = Languages.getLanguageQuery(code, requestSpec);

        response.then()
                .assertThat()
                .statusCode(200)
                .body("data.language.code", is(code))
                .body("data.language.name", is(name))
                .body("data.language.native", is(languageNative));
    }
}