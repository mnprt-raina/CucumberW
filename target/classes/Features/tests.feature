Feature: Testing wallmart login and update personal info

Scenario: Login to wallmart
Given Application "WALMART" is launched
When Verify title of page is "walmart"
Then User hovers over "signinhover"
Then User clicks on "SignIn" button
Then User enters "mnprt.raina@gmail.com" on "Username" element
Then User enters "1LoveZindagi" on "password" element
Then User clicks on "signinbutton" button

Scenario: Update contact details
When Verify title of page is "PersonalSettings"
Then User hovers over "MyAccount"
Then User clicks on "editPersonalInformation" button
Then User clicks on "edit" button
Then User enters "8723828783" on "phonenumber" element
Then User clicks on "save" button

 






