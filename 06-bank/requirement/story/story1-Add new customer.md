####Story 1

```
As an Account Administrator
 I would like the bank to track new customers
 So that we can tie all records of them together

Acceptance Criteria:

* Each customer has a ‘nickname’
* Valid ‘nickname’s contain only lowercase letters or digits
* Each customer has a ‘dateOfBirth’ (DateTime)
* Customers may be added to the Bank provided that there is not an existing customer with the same ‘nickname’

```

#####TODO-List

1. should create customer instance with valid customer information.
2. should raise error if nickname has uppercase letters when create customer instance.
3. should raise error if nickname has special character when create customer instance.
4. should raise error if customer didn't have dateOfBirth when create customer instance.
5. should add customer with valid customer information when add a customer in bank.
6. should raise error if the nickname already existed when add a customer in bank.

####Required Tech

1. Story
2. TDD

####Check
