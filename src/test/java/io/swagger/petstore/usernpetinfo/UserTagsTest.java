package io.swagger.petstore.usernpetinfo;

import io.swagger.petstore.constants.Endpoints;
import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UserTagsTest extends TestBase {
    @WithTags({
            @WithTag("petstorefeature: SMOKE"),
            @WithTag("petstorefeature: REGRESSION"),
    })
    @Title("Provide a 415 status code when incorrect HTTP method is used to access resource")
    @Test
    public void invalidMethod() {
        SerenityRest.rest()
                .given()
                .when()
                .post("/v2/user")
                .then()
                .statusCode(415)
                .log().all();
    }

    @WithTags({
            @WithTag("petstorefeature: SANITY"),
            @WithTag("petstorefeature: REGRESSION"),
    })
    @Title("This test will verify if a status code of 200 is returned for GET request")
    @Test
    public void verifyIfTheStatusCodeIs200() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/v2/user/string")
                .then()
                .statusCode(200)
                .log().all();
    }

    @WithTag("petstorefeature: REGRESSION")
    @Title("This test will provide an error code of 405 when user tries to access an invalid resource")
    @Test
    public void inCorrectResource() {
        SerenityRest.rest()
                .given()
                .when()
                .get("v2/user")
                .then()
                .statusCode(405)
                .log().all();
    }
}
