# Framework Development Lab

## Overview
This repository contains the implementation and design of a framework and two applications: a banking system and a credit card processing system.
The project focuses on utilizing design patterns to create reusable and maintainable components.

# Features

Banking System

	•	Use Cases:	Create a personal account, Create a company account (checking or savings), Deposit money, Withdraw money, Add interest, Generate a report of accounts
	•	Operations: Add interest to all accounts, Notify via email for specific transactions (e.g., high-value deposits/withdrawals), Maintain transaction history for each account.

Credit Card Processing System

	•	Use Cases: Create a credit card account, Deposit money, Charge the account, Add interest, Generate monthly billing report
	•	Card Types: Gold, Silver, Bronze
	•	Operations: Notify cardholders for high-value transactions, Maintain history of charges and payments, Generate a detailed monthly billing report.

Framework

	•	A reusable framework named Observable Party Account Framework that supports: Abstracting common operations between banking and credit card systems. Utilizing design patterns such as:
	•	Account Pattern: For account operations, Party Pattern: For managing customers and organizations, Observer Pattern: For notifications and updates.

Implementation

The project is divided into the following packages:
	1.	Framework: Contains reusable components and abstract classes/interfaces.
	2.	Banking: Implements the banking application using the framework.
	3.	CreditCard: Implements the credit card application using the framework.

Setup and Usage

	1.	Clone the repository:

git clone <repository_url>

	2.	Navigate to the project directory and build the framework and applications:

cd FrameworkDevelopmentLab

	3.	Run the banking or credit card application:

java -cp banking.Main
java -cp creditcard.Main

Contributions

Feel free to open issues and submit pull requests to improve the framework or applications.

License

This project is licensed under the MIT License. See the LICENSE file for details.
