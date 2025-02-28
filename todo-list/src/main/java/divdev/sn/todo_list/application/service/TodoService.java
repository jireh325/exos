package divdev.sn.todo_list.application.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import divdev.sn.todo_list.application.port.in.UseCasePort;
import divdev.sn.todo_list.application.port.out.TodoRepository;
import divdev.sn.todo_list.domain.model.Todo;

@Service
public class TodoService implements UseCasePort {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo create(Todo todo){
        return this.todoRepository.save(todo);
    }

    @Override
    public Optional<Todo> getOne(String id){
        return this.todoRepository.findById(id);
    }

    @Override
    public List<Todo> getAll(){
        return this.todoRepository.findAll();
    }

    @Override
    public void delete(String id){
        this.todoRepository.delete(id);
    }

    @Override
    public Todo update(String id, Todo todo){
        return this.todoRepository.update(id, todo);
    }
}
