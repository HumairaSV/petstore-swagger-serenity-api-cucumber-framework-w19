Feature: Pet store app

  As a user I want to test the Pet store user api

  Scenario Outline: Pet store user CRUD test
    Given I am on the Pet store swagger page
    When  I create a new user by providing the information id "<id>" username "<username>" firstname "<firstname>" lastname "<lastname>" email "<email>" password "<password>" phone "<phone>" userstatus "<userstatus>"
    Then  I verify the user with username "<username>" is created
    And   I update the user with information id "<id>" username "<username>" firstname "<firstname>" lastname "<lastname>" email "<email>" password "<password>" phone "<phone>" userstatus "<userstatus>"
    And   I verify that the user with the username "<username>" has been updated successfully
    And   I delete the user created with username "<username>"
    Then  I verify that the user with username "<username>"is deleted successfully from the database
    Examples:
      | id  | username  | firstname   | lastname | email                     | password    | phone      | userstatus |
      | 53  | edomico0  | Ernie       | Domico   | edomico0@behance.net      | 70z209L     | 2716810960 | 0          |
      | 348 | bfautley1 | Barbaraanne | Fautley  | bfautley1@dagondesign.com | fUKnLjrIuLc | 7804723716 | 0          |
      | 802 | svaar2    | Siusan      | Vaar     | svaar2@amazonaws.com      | 5X4rqvtU    | 1504124550 | 0          |