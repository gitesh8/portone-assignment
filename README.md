# Payment API Endpoints

This repository contains endpoints for managing payment intents and refunds using the Stripe API.

## Getting Started

To use these endpoints, ensure you have an account with Stripe and obtain your API keys.

### Postman Collection

Explore and test the API endpoints using [Postman](https://www.postman.com/). Postman collection link [click here](https://www.postman.com/bold-station-66254/workspace/portone-assignment/request/21698330-b98868e9-c9d5-46b7-8e44-a4b8c94fbe6c?action=share&creator=21698330&ctx=documentation).

## Endpoints

### 1. Create Payment Intent

Endpoint: `POST /api/v1/create_intent`

#### Description:
Creates a new payment intent.

#### Request Body

```json
{
  "amount": 1000,
  "currency": "usd",
  "customerEmail": "customer@example.com"
}
```
### 2. Capture Payment Intent

Endpoint: `POST /api/v1/capture_intent/{id}`

#### Description:
Captures a pending payment intent specified by {id}.

#### Path Parameters

`{id}: The ID of the payment intent to be captured`.

### 3. Create Refund

Endpoint: `POST /api/v1/create_refund/{id}`

#### Description:
Creates a refund for a payment intent.

#### Path Parameters:

`{id}: ID of the payment intent for which refund is to be created.`

### 4. Get Payment Intents

Endpoint: `GET /api/v1/get_intents/`

#### Description:
Retrieves a list of payment intents.

## Test Payment with Card Details
For testing purposes, you can use the following card details:

- **Card Number:** 4242 4242 4242 4242
- **Expiry Date:** Any future date
- **CVV:** Any 3-digit number

 #### You have to pass the client secret received from payment intent to this url
 Link: `https://portone-assignment.netlify.app/?client-secret={client_secret}`

## Usage
To use these endpoints, ensure you have the necessary Stripe credentials configured in your environment. Replace {id}, amount, currency, and customerEmail with appropriate values when making requests.

## Setup

- **Clone the repository.**
- **Install dependencies (stripe-java,spring web, gson, spring boot dev tools, lombok).**
- **Configure your Stripe API keys.**
