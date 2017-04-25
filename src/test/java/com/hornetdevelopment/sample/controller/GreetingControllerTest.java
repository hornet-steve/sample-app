package com.hornetdevelopment.sample.controller;

import com.hornetdevelopment.sample.controller.validation.InvalidUUIDException;
import com.hornetdevelopment.sample.domain.Greeting;
import com.hornetdevelopment.sample.service.GreetingService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.UUID;

/**
 * Created by steve on 4/24/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class GreetingControllerTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Mock
    private GreetingService greetingService;

    @InjectMocks
    private GreetingController greetingController;

    private String notAUUID = "not_a_uuid";

    @Test
    public void testListGreetings() {
        List<Greeting> result = greetingController.listGreetings();
        Mockito.verify(greetingService).listGreetings();
    }

    @Test
    public void testGetGreetingById() {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        greetingController.getGreetingById(uuidString);
        Mockito.verify(greetingService).getGreetingById(uuid);
    }

    @Test
    public void testGetGreetingByIdWithInvalidUUID() {
        exception.expect(InvalidUUIDException.class);
        greetingController.getGreetingById(notAUUID);
    }

    @Test
    public void testCreateGreeting() {
        Greeting greeting = new Greeting();
        greetingController.createGreeting(greeting);
        Mockito.verify(greetingService).createGreeting(greeting);
    }

    @Test
    public void testUpdateGreeting() {
        Greeting greeting = new Greeting();
        String id = UUID.randomUUID().toString();
        greetingController.updateGreeting(greeting, id);
        Mockito.verify(greetingService).updateGreeting(greeting, UUID.fromString(id));
    }

    @Test
    public void testUpdateGreetingWithInvalidUUID() {
        Greeting greeting = new Greeting();
        exception.expect(InvalidUUIDException.class);
        greetingController.updateGreeting(greeting, notAUUID);
    }

    @Test
    public void testDeleteGreeting() {
        String id = UUID.randomUUID().toString();
        greetingController.deleteGreeting(id);
        Mockito.verify(greetingService).deleteGreeting(UUID.fromString(id));
    }

    @Test
    public void testDeleteGreetingWithInvalidUUID() {
        exception.expect(InvalidUUIDException.class);
        greetingController.deleteGreeting(notAUUID);
    }
}
