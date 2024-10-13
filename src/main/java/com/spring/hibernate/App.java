package com.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // start new session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        // create UserDetails Object
        UserDetails userDetails = new UserDetails();
        userDetails.setAddress("Egypt");
        userDetails.setPhone("Alex");
        // create friends object
        Friends friends1 = new Friends();
        friends1.setName("Ahmed");
        Friends friends2 = new Friends();
        friends2.setName("Mohamed");

        List<Friends> friends = new ArrayList<>();
        friends.add(friends1);
        friends.add(friends2);

        // create user object and set the relation
        User user = new User();
        user.setName("John Doe");
        user.setAge(30);
        user.setDetails(userDetails);
        user.setFriends(friends);
        // create post object
        Post post1 = new Post();
        post1.setHeader("First Post");
        post1.setContent("This is John's first post.");
        post1.setUser(user);

        Post post2 = new Post();
        post2.setHeader("Second Post");
        post2.setContent("This is John's second post.");
        post2.setUser(user);

        // Add posts to user
        user.setPosts(List.of(post1, post2));

        // Persist the User (which will also persist the UserDetails, Friends, and Posts)
        session.save(user);

        // Commit transaction
        transaction.commit();

        // Close the session
        session.close();

        System.out.println("User, UserDetails, Friends, and Posts saved successfully!");
    }
}
