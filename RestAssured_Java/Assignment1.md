# Assignment 1 - REST Assured Basics (DummyJSON)

## Setup - Done

-   Java + Maven
-   Rest Assured dependency
-   TestNG or JUnit

------------------------------------------------------------------------

## Task 1: Basic GET validation

Endpoint: /products

Validate: - Status code = 200 - Response time \< 2s - total \> 0 -
products array not empty

------------------------------------------------------------------------

## Task 2: Schema assertions

Validate: - id is integer - title is not null - price \> 0 -
discountPercentage exists

------------------------------------------------------------------------

## Task 3: Query params

/products?limit=5&skip=10

Validate: - 5 products returned - skip working

------------------------------------------------------------------------

## Task 4: Single resource

/products/1

Validate: - id = 1 - title not empty - category exists

------------------------------------------------------------------------

## Task 5: Negative case

/products/999999 → 404

------------------------------------------------------------------------

## Task 6: POST

/products/add

Body: { "title": "QA Test Product", "price": 999 }

Validate: - response contains same data - id generated

------------------------------------------------------------------------

## Task 7: Extract + reuse

-   Find highest priced product
-   Assert price \> 1000

------------------------------------------------------------------------

## Task 8: Auth

/auth/login

Validate token exists

------------------------------------------------------------------------

## Task 9: Chaining

Login → /auth/me

------------------------------------------------------------------------

## Task 10: Logging

Log request & response
