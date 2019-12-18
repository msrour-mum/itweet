package mum.itweet.config;

import mum.itweet.model.*;
import mum.itweet.model.lookups.Gender;
import mum.itweet.model.lookups.PostStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class DataGenerate {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu");

    public static void Generate() {
        //SpringApplication.run(ItweetApplication.class, args);


        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Role roleAdmin = new Role(1, "Admin Roll");
        Role roleUser = new Role(2, "User Roll");
        User userAdmin1 = new User("Admin", "admin@mum.com", true, roleAdmin, "123", true, new Date(), 1, "1232", "Admin User");
        User userAdmin2 = new User("Admin Zein", "adminzein@mum.com", true, roleAdmin, "123", true, new Date(), 1, "1232", "Admin User");
        User userAdmin3 = new User("Admin Mah", "adminmah@mum.com", true, roleAdmin, "123", true, new Date(), 1, "1232", "Admin User");
        User userAdmin4 = new User("Admin Ibrahim", "adminIbrahim@mum.com", true, roleAdmin, "123", true, new Date(), 1, "1232", "Admin User");


        User user1 = new User("Moustafa Zein", "user1@mum.com", false, roleAdmin, "123", true, new Date(), 1, "1232", "User 1");
        User user2 = new User("Mahmoud Srour", "user2@mum.com", false, roleAdmin, "123", true, new Date(), 1, "1232", "User 2");
        User user3 = new User("Mo Salah", "user3@mum.com", false, roleAdmin, "123", true, new Date(), 1, "1232", "User 3");
        User user4 = new User("Ibrahim Samer", "user4@mum.com", false, roleAdmin, "123", true, new Date(), 1, "1232", "User 4");
        User user5 = new User("Mobark Salem", "user5@mum.com", false, roleAdmin, "123", true, new Date(), 1, "1232", "User 5");
        User user6 = new User("Yasser Kmal", "user6@mum.com", false, roleAdmin, "123", true, new Date(), 1, "1232", "User 6");
        User user7 = new User("Said Said", "user7@mum.com", false, roleAdmin, "123", true, new Date(), 1, "1232", "User 7");

        em.persist(roleAdmin);
        em.persist(roleUser);

        em.persist(userAdmin1);
        em.persist(userAdmin2);
        em.persist(userAdmin3);
        em.persist(userAdmin4);


        em.persist(user1);
        em.persist(user2);
        em.persist(user3);
        em.persist(user4);
        em.persist(user5);
        em.persist(user6);
        em.persist(user7);

        for (int i = 8; i < 15; i++) {
            User userTemp = new User("Name : " + i, "user" + i + "@mum.com", false, roleAdmin, "123", true, new Date(), 1, "1232", "Bio " + i);
            em.persist(userTemp);
        }


        TypedQuery<User> q = em.createQuery("from User where isAdmin=0", User.class);
        List<User> users = q.getResultList();
        int postCount = 1;

        for (User userM : users) {
            for (User userS : users) {
                if (doRandom(4,1)) {
                    Following following = new Following(userS, userM, new Date());
                    em.persist(following);
                }
            }
        }

        for (User user : users) {
            for (int i = 0; i < 7; i++) {

                PostStatus p = PostStatus.Active;
                boolean isNotActivePost =doRandom(10,i);
                if(isNotActivePost)
                    p=PostStatus.Pending;

                Post post = new Post(user, "This is post " + postCount + "from user :" + user.getEmail(), p, null, null, new Date(), new Date());
                em.persist(post);

                if(!isNotActivePost) {
                    for (User userAction : users) {
                        if (doRandom(3, i)) {
                            //Comment comment = new Comment(userAction, post, "This comments from user " + userAction.getEmail());
                            Comment comment = new Comment(userAction,  "This comments from user " + userAction.getEmail());
                            post.addComment(comment);
                            em.persist(post);
                        }

                        if (doRandom(4, i)) {
                            //PostLikes postLikes = new PostLikes(userAction, post, true, new Date());
                            //em.persist(postLikes);
                        }
                    }
                }
                postCount++;
            }
        }


        em.getTransaction().commit();
        emf.close();


    }

    public static boolean doRandom(int factor , int seed) {
        Random rand = new Random();
        int randNo = rand.nextInt(1000*seed+1);
        if (randNo % factor == 0) return true;
        return false;
    }
}
