package io.swagger.petstore.usernpetinfo;


import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

@Concurrent(threads = "2x")
@UseTestDataFrom("src/test/java/resources/testdata/userdata.csv")
@RunWith(SerenityParameterizedRunner.class)
public class UserDataDrivenTesting extends TestBase {

    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

    @Steps
    UserSteps userSteps;

    @Title("Data driven Test to add multiple bookings to the api")
    @Test
    public void createMulitpleUsers() {
        userSteps.createUser(id,username,firstName,lastName,email,password,phone,userStatus);
    }

}
