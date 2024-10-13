# Hibernate Inheritance Project

## Project Overview

This project demonstrates the use of **Hibernate ORM** to implement various entity relationships and inheritance strategies in a Java-based Spring application. It involves creating a model of `User`, `UserDetails`, `Friends`, and `Post`.

## Technologies Used

- **Java** (JDK 8 or higher)
- **Hibernate ORM** (Version 5.x)
- **MySQL** (or any other relational database)
- **Spring Framework**
- **Maven** (for dependency management)

## Features

1. **One-to-One Relationship**:
   - `User` has one `UserDetails`.
![Screenshot 2024-10-13 210446](https://github.com/user-attachments/assets/ad71ce37-39b3-430b-b9b0-4b5477978f4f)

2. **Many-to-Many Relationship**:
   - `User` can have many `Friends`, and `Friends` can be associated with many `Users`.

3. **One-to-Many Relationship**:
   - `User` can have many `Post`s, but each `Post` belongs to only one `User`.

## Project Structure

- **Entities**:
  - `User`: The base entity representing common attributes.
  - `UserDetails`: Contains address and phone details for a `User`.
  - `Friends`: Represents the friends of a user in a many-to-many relationship.
  - `Post`: Represents posts created by a user.

- **Relationships**:
  - `User` ↔ `UserDetails` (One-to-One)
  - `User` ↔ `Friends` (Many-to-Many)
  - `User` ↔ `Post` (One-to-Many)


## Database Schema

When using the **Joined Table** strategy, Hibernate generates the following tables:
- `user` (common fields for all users)
- `user_details`, `friends`, `post`, `user_friends` (for other relationships)

