package com.hornetdevelopment.sample.service;

import com.hornetdevelopment.sample.domain.Greeting;
import com.hornetdevelopment.sample.service.validation.GreetingNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by steve on 4/21/17.
 */
@Service
public class GreetingService {

    // for simplicity, this will serve as the data layer for this sample application
    private final Map<UUID, Greeting> dataLayer = new HashMap<>();

    public List<Greeting> listGreetings() {
        // Java 8 stream with map example
        return dataLayer.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public Greeting getGreetingById(final UUID id) {
        // Java 8 filter example
        return dataLayer.values().stream()
                .filter(greeting -> greeting.getId().equals(id))
                .findFirst()
                // the "long" way
                //.orElseThrow(() -> new GreetingNotFoundException());
                // the "shorthand" or method reference way
                .orElseThrow(GreetingNotFoundException::new);
    }

    public Greeting createGreeting(final Greeting greeting) {
        greeting.setId(UUID.randomUUID());
        dataLayer.put(greeting.getId(), greeting);
        return greeting;
    }

    public Greeting updateGreeting(final Greeting greeting, final UUID id) {
        // in practice this would be elaborated in the application architecture/design but will keep simple for
        // this sample application
        Greeting existing = getGreetingById(id);

        existing.setName(greeting.getName());
        existing.setGreeting(greeting.getGreeting());

        dataLayer.put(existing.getId(), existing);

        return existing;
    }

    public void deleteGreeting(final UUID id) {
        dataLayer.remove(getGreetingById(id).getId());
    }

}
