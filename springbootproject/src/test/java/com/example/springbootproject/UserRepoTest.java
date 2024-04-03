package com.example.springbootproject;

// import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.springbootproject.model.User;
import com.example.springbootproject.repository.UserRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepoTest {
    @Autowired
    private UserRepo repo;
    
    @Autowired
    private TestEntityManager entitymanager;

    @Test
    public void testCreateUser()
    {
        User user=new User();
        user.setEmail("dharsha@gmail.com");
        user.setPassword("dharsha");
        user.setFirstName("Dharsha");
        user.setLastName("N");

        User saveduser=repo.save(user);

        User existuser=entitymanager.find(User.class,saveduser.getId());
        // assertThat(existuser.getEmail()).isEqualTo( user.getEmail());
        // assertThat(existuser.getEmail(), is(equalTo(user.getEmail())));
        assertEquals(existuser.getEmail(), user.getEmail());
  
    }

}
