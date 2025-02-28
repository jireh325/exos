package divdev.sn.todo_list.infrastructure.adapter.in.graphQl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import divdev.sn.todo_list.application.port.in.UseCasePort;
import divdev.sn.todo_list.application.port.out.TodoRepository;
import divdev.sn.todo_list.domain.model.Todo;

@Controller
public class TodoGraphQLController implements UseCasePort{

    private final TodoRepository todoRepository;

    public TodoGraphQLController(@Qualifier("todoMongoAdapter") TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @QueryMapping(name = "getAllTodos")
    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @QueryMapping(name = "getOneTodo")
    @Override
    public Optional<Todo> getOne(@Argument String id) {
        return todoRepository.findById(id);
    }

    @MutationMapping(name = "createTodo")
    @Override
    public Todo create(@Argument("todo") Todo todo) {
        return todoRepository.save(todo);
    }

    @MutationMapping(name = "updateTodo")
    @Override
    public Todo update(@Argument String id, @Argument("todo") Todo todo) {
        return todoRepository.update(id, todo);
    }

    @MutationMapping(name = "delete")
    @Override
    public void delete(@Argument String id) {
        todoRepository.delete(id);
    }
}
