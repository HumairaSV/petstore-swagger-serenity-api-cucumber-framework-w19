Feature: Testing different requests on the pet store user api

  As a user I want to test if data can be accessed, created,updated and deleted on the pet store user api

  Background: pet store user api is running

  Scenario: Check if a new user can be created on the pet store user api
    When  I send a POST request to user endpoint with the information id "225971" username "franrook235" firstname "Fran" lastname "Rookledge" email "franRoock@gmail.com" password "pass125978" phone "54657874455" userstatus "0"
    Then  I must get back a valid status code "200"


  Scenario: Check if the pet store api can be accessed by users by searching username
    When  I send a GET request to username endpoint
    Then  I must get back a valid status code "200"


  Scenario: Check if the pet store api can be updated by users by searching username
    When  I send a PUT request to username endpoint with updated information id "225971" username "franrook235_updated" firstname "Fran" lastname "Rookledge" email "franRoock@gmail.com" password "pass125978" phone "54657874455" userstatus "0"
    Then  I must get back a valid status code "200"


  Scenario: Check if the user can be deleted from pet store api by searching for username
    When  I send a DELETE request to username endpoint
    Then  I must get back a valid status code "201"
