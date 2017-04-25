package com.hornetdevelopment.sample.service;

import com.hornetdevelopment.sample.domain.Greeting;
import com.hornetdevelopment.sample.service.validation.GreetingNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.UUID;

/**
 * Created by steve on 4/24/17.
 */
public class GreetingServiceTest {
    // normally we would mock the data layer and inject here but since it's embedded for the
    // sample app's simplicity, we won't do that
    private GreetingService greetingService = new GreetingService();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private Greeting greeting1;
    private Greeting greeting2;

    @Before
    public void setUp() {
        // add some Greetings to work with
        Greeting g1 = new Greeting();
        g1.setName("name1");
        g1.setGreeting("greeting1");

        Greeting g2 = new Greeting();
        g2.setName("name2");
        g2.setGreeting("greeting2");

        greeting1 = greetingService.createGreeting(g1);
        greeting2 = greetingService.createGreeting(g2);
    }

    @Test
    public void testListGreetings() {
        List<Greeting> result = greetingService.listGreetings();
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void testGetGreetingById() {
        Greeting g1 = greetingService.getGreetingById(greeting1.getId());

        Assert.assertEquals(greeting1.getId(), g1.getId());
        Assert.assertEquals(greeting1.getGreeting(), g1.getGreeting());
        Assert.assertEquals(greeting1.getName(), g1.getName());
    }

    @Test
    public void testGetGreetingByIdWithUnknownId() {
        exception.expect(GreetingNotFoundException.class);
        greetingService.getGreetingById(UUID.randomUUID());
    }

    @Test
    public void testCreateGreeting() {
        Greeting greeting = new Greeting();
        greeting.setName("aName");
        greeting.setGreeting("aGreeting");

        Greeting created = greetingService.createGreeting(greeting);
        Greeting foundById = greetingService.getGreetingById(created.getId());

        Assert.assertEquals(3, greetingService.listGreetings().size());
        Assert.assertEquals(created.getId(), foundById.getId());
    }

    @Test
    public void testUpdateGreeting() {
        greeting2.setName("aNewName");
        greeting2.setGreeting("aNewGreeting");

        Greeting updated = greetingService.updateGreeting(greeting2, greeting2.getId());

        Assert.assertEquals(greeting2.getId(), updated.getId());
        Assert.assertEquals("aNewName", updated.getName());
        Assert.assertEquals("aNewGreeting", updated.getGreeting());
    }

    @Test
    public void testUpdateGreetingWithUnknownId() {
        Greeting greeting = new Greeting();
        greeting.setId(UUID.randomUUID());
        greeting.setName("aName");
        greeting.setGreeting("aGreeting");

        exception.expect(GreetingNotFoundException.class);
        greetingService.updateGreeting(greeting, greeting.getId());
    }

    @Test
    public void testDeleteGreeting() {
        greetingService.deleteGreeting(greeting2.getId());

        List<Greeting> greetings = greetingService.listGreetings();

        Assert.assertEquals(1, greetings.size());
        greetings.forEach((greeting -> Assert.assertNotEquals(greeting2.getId(), greeting.getId())));
    }

    @Test
    public void testDeleteGreetingWithUnknownId() {
        exception.expect(GreetingNotFoundException.class);
        greetingService.deleteGreeting(UUID.randomUUID());
    }
}
