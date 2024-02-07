package dev.danvega;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class TodoClient {

    private static final Logger log = LoggerFactory.getLogger(TodoClient.class);
    private final RestClient restClient;

    public TodoClient(@Qualifier("restClientTwo") RestClient restClient) {
        this.restClient = restClient;
    }

    public Todo findById(int i) {

        var todo = restClient.get()
                .uri("/todos/1")
                .retrieve()
                .body(Todo.class);

        log.info(String.valueOf(todo));
        return todo;
    }
}
