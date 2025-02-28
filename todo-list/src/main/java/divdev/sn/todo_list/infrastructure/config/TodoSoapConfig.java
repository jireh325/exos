package divdev.sn.todo_list.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import divdev.sn.todo_list.infrastructure.adapter.in.soap.TodoSoapService;
import jakarta.xml.ws.Endpoint;

@Configuration
public class TodoSoapConfig {

    @Bean
    public Endpoint endpoint(TodoSoapService todoSoapController) {
        String url = "http://localhost:8081/ws/todo";
        return Endpoint.publish(url, todoSoapController);
    }
}
