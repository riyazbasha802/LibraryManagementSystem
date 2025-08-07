Java Library Management System (Console-based)
📌 Project Overview
This project is a simple, console-based Library Management System developed in Java using Object-Oriented Programming (OOP) principles. It allows users to register, view available books, issue books, return them, and view issued books.

🎯 Objectives
Apply and understand core OOP concepts in Java.

Practice class design, encapsulation, dynamic behavior, and code reuse.

Build a multi-class Java application using VS Code & terminal.

🧠 Key OOP Concepts Implemented
Concept Implementation Example
Abstraction Methods like issueBook() hide internal logic behind interfaces
Encapsulation Private fields and public getters/setters in each class
Polymorphism Could be extended (e.g., LibraryItem interface for books)
Inheritance Practical use-case open (e.g., Book, Journal from LibraryItem)
📁 Project Structure
bash
📁 LibraryManagementSystem
├── Book.java # Book class with attributes and methods
├── User.java # User class with books issued and operations
└── Library.java # Main class that runs the console-based UI
🧱 Class Descriptions
👉 Book.java
Represents a book with ID, title, author, and availability status.

👉 User.java
Represents a library user with a unique ID, name, and records of issued books.

👉 Library.java
Acts as the main application handler with menu options to interact with books and users via terminal.

🛠️ Tools & Technologies
Language: Java

IDE: VS Code (or any Java-supported editor)

CLI: Terminal / Command Prompt

JDK: Version 8 or above recommended

🚀 How to Run
Clone or download the project directory.

Open the folder in VS Code or any Java-supported IDE.

Compile the project:

bash
javac *.java
Run the program:

bash
java Library
📌 Features
✅ View available books

✅ Register a new user

✅ Issue books to users

✅ Return books from users

✅ Display books issued by a specific user

✅ Sample Output
text
📚 Library Menu
1. View Books
2. Register User
3. Issue Book
4. Return Book
5. Show Issued Books
0. Exit
