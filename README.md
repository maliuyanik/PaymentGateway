# PayFlex - Payment Processing Simulation

This project is a backend simulation of a payment processing system. It supports multiple payment methods (Credit Card and Crypto) and demonstrates how to handle transactions using **Object-Oriented Programming** principles.

The main goal of this project was to implement **Dependency Injection** manually (without frameworks) and ensure **Loose Coupling** between components.

## Key Concepts Implemented

* **Polymorphism:** A single `processPayment()` method handles different payment types (Credit Card vs. Crypto).
* **Dependency Injection:** `Logger` and `Network` services are injected via constructors, making the code testable and flexible.
* **Encapsulation:** Sensitive data (like card numbers) is masked and field access is restricted.
* **Interface-Driven Design:** System relies on `ILogger`, `INetworkConnection`, and `IPaymentProcessor` interfaces rather than concrete implementations.
* **Enum State Management:** Transaction results are handled using Type-Safe Enums instead of magic strings.

## Project Structure

* `interfaces/`: Contracts for Payment, Logger, and Network.
* `core/`: Abstract base classes and Enums.
* `impl/`: Concrete implementations (CreditCardPayment, ConsoleLogger, etc.).
* `Main.java`: Runs the simulation with batch processing.

## Usage Example

```java
// 1. Setup Dependencies (Mock Services)
ILogger logger = new ConsoleLogger();
INetworkConnection network = new MockNetworkAdapter();

// 2. Create Payment Object (Injecting dependencies)
IPaymentProcessor payment = new CreditCardPayment(
    "1234567812345678", // Card Number
    2000.0,             // Limit
    logger,             // Injected Logger
    network             // Injected Network
);

// 3. Process Transaction
PaymentStatus result = payment.processPayment(150.0);

if (result == PaymentStatus.SUCCESS) {
    System.out.println("Payment verified.");
}
