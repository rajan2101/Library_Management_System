## Project Overview:
This is a Java-based Library Management System (LMS) designed to manage books, members, and publishers within a library environment. The project transitions from traditional JDBC to Hibernate ORM, implementing a clean DAO (Data Access Object) Layered Architecture as taught in recent modules.

## Key Features:
Publisher Management: Full CRUD operations for library book suppliers.
Member Management: Tracking library members, membership types, and expiry dates based on registration data.
Book Management: Organizing library inventory with a "Published By" relationship mapping.
Relational Mapping: Implements @ManyToOne and @OneToMany relationships as defined in the project's ER diagram.
XML-less Configuration: Uses a 100% Java-based Hibernate configuration via HibernateUtil.

## System Architecture:
The project is organized into distinct packages to ensure high maintainability:
com.lms.model: Contains Entity classes mapped to the database (Book, Member, Publisher).
com.lms.dao: Implements the Generic DAO pattern for database transactions.
com.lms.util: Holds the HibernateUtil for SessionFactory management.
com.lms.app: The entry point featuring a console-based menu system with user input validation.

## Database Schema (ER Diagram):
The system is built upon a relational schema featuring:
Books: Attributes include Book ID, Title, Author, Price, and Availability.
Publisher: Connected to Books via a "Published By" (1:M) relationship.
Member: Tracks individual user data including Member Type and join dates.

## Technologies Used:
Language: Java (JDK 11+)
Framework: Hibernate 5.6.x (ORM)
Database: MySQL 8.0
Build Tool: Maven
Environment: Eclipse IDE

## LMS Project Directory Hierarchy:
```LibraryManagementSystem/
├── pom.xml                        # Maven dependencies (Hibernate, MySQL)
└── src/
    ├── main/
    │   ├── java/                  # All your Java packages
    │   │   └── com/
    │   │       └── lms/
    │   │           ├── app/       # Main execution class (LMSApp.java)
    │   │           ├── config/    # Hibernate configuration (HibernateUtil.java)
    │   │           ├── dao/       # Data Access Objects (GeneralDao.java)
    │   │           └── model/     # Entity classes (Book, Member, Publisher)
    │   └── resources/             # Empty (since you're not using XML config)
    └── test/                      # Optional: For unit testing your logic
```
