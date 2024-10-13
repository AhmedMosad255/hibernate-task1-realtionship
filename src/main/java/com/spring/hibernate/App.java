package com.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main(String[] args)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // 1. Create UserDetails object
        UserDetails userDetails = new UserDetails();
        userDetails.setAddress("Egypt");
        userDetails.setPhone("Alex");

        // Save UserDetails first
        session.save(userDetails);

        // 2. Create Friends objects
        Friends friends1 = new Friends();
        friends1.setName("Ahmed");
        Friends friends2 = new Friends();
        friends2.setName("Mohamed");

        // Save Friends first
        session.save(friends1);
        session.save(friends2);

        List<Friends> friends = new ArrayList<>();
        friends.add(friends1);
        friends.add(friends2);

        // 3. Create User object and set relationships (without saving User yet)
        User user = new User();
        user.setName("John Doe");
        user.setAge(30);
        user.setDetails(userDetails);
        user.setFriends(friends);

        // Save User (without saving the posts yet)
        session.save(user);

        // 4. Create Post objects and associate them with the user
        Post post1 = new Post();
        post1.setHeader("First Post");
        post1.setContent("This is John's first post.");
        post1.setUser(user);

        Post post2 = new Post();
        post2.setHeader("Second Post");
        post2.setContent("This is John's second post.");
        post2.setUser(user);

        // Save the posts
        session.save(post1);
        session.save(post2);

        user.setPosts(List.of(post1, post2));

        // Commit the transaction
        transaction.commit();

        // Close the session
        session.close();

        System.out.println("User, UserDetails, Friends, and Posts saved successfully!");
    }
}
