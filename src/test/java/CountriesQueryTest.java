import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import queries.Countries;

import static org.hamcrest.Matchers.is;


public class CountriesQueryTest extends BaseTest{

    @Test
    public void shouldReturnStatus200() {
        String country = "AR";
        Response response = Countries.getCountryQuery(country, requestSpec);
        //response.then().log().body(); //- Verify Body API return
        response.then().
                assertThat().
                statusCode(200).body("data.country.code", is(country));
    }

    @DataProvider(name = "countries")
    public Object[][] countriesData(){
        return new Object[][]{
                {"BR", "Brazil"},
                {"AR", "Argentina"},
                {"US", "United States"},
                {"CA", "Canada"},
        };
    }

    @Test(dataProvider = "countries")
    public void shouldVerifyMultiplesCodeAndNameCountry(String countryCode, String countryName) {
        Response response = Countries.getCountryQuery(countryCode, requestSpec);

        response.then()
                .assertThat()
                .statusCode(200)
                .body("data.country.code", is(countryCode))
                .body("data.country.name", is(countryName));
    }
}