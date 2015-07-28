####Story 3

```
As a Bank Manager
 I would like customers to receive a welcome message when being added
 So that they feel like we are engaged with them

```

Notes:

* You must use the Bank’s Message Gateway API (provided)

Acceptance Criteria:

* A message is sent to the customer who was added to the bank
* The message is addressed to the customer’s email address – the form is: nickname@thebank.com
* The message content is “Dear <nickname>, Welcome to the Bank”

#####TODO-List

1. should create customer instance with valid customer information.
2. should raise error if nickname has uppercase letters when create customer instance.
3. should raise error if nickname has special character when create customer instance.
4. should raise error if customer didn't have dateOfBirth when create customer instance.
5. should add customer with valid customer information when add a customer in bank.
6. should raise error if the nickname already existed when add a customer in bank.

####Required Tech

####Check