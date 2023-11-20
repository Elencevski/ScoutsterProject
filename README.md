# ScoutsterProject


Overview

This project is an individual endeavor aimed at creating a hiking club platform that allows users to select hiking tours. The platform implements CRUD operations and operates as a SaaS (Software as a Service) solution, to enhance user experiences through social media integration. It incorporates Spring Social for Facebook integration and requires PostgreSQL to store hardcoded data.
Features

    CRUD Operations: The platform supports Create, Read, Update, and Delete operations for hiking tours.
    SaaS Platform: Utilizes a Software as a Service model for accessibility, enables users to log in using their Facebook credentials.
   

Requirements

    Java SpringBoot
    PostgreSQL
    Thymeleaf

Installation

    Clone the repository: git clone https://github.com/yourusername/hiking-club-platform.git
    Set up PostgreSQL:
        Install PostgreSQL and create a database.
        Modify application.properties to configure the database connection.
    Run the application: Use Maven to build and run the application.

Usage

    Logging in:
        Navigate to the registration page.
        Click on "Login with Facebook" to use Facebook credentials. Or you can register without it
    Exploring Tours:
        Access the "Tours" section to view available hikes.
        Select a tour to view details and make a reservation.

Known Limitations

    Only the "Tours" section and "Reservation" functionality are currently functional.
    The application is not hosted live and needs to be downloaded and run locally.

Future Improvements

    Implement functionality for other sections.
    Enhance user authentication methods.
    Host the application for live usage.
