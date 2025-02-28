package divdev.sn.todo_list.infrastructure.adapter.in.rest;

import divdev.sn.todo_list.application.port.in.UseCasePort;
import divdev.sn.todo_list.application.port.out.TodoRepository;
import divdev.sn.todo_list.domain.model.Todo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Todo")
class TodoRestController implements UseCasePort {

    private final TodoRepository todoRepository;

    public TodoRestController(@Qualifier("todoJpaAdapter") TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping
    @Override
    public Todo create(@RequestBody Todo todo) {
        return this.todoRepository.save(todo);
    }

    @GetMapping
    @Override
    public List<Todo> getAll() {
        return this.todoRepository.findAll();
    }

    @GetMapping("/{id}")
    @Override
    public Optional<Todo> getOne(@PathVariable String id) {
        return this.todoRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        this.todoRepository.delete(id);
    }

    @PutMapping("/{id}")
    @Override
    public Todo update(@PathVariable String id, @RequestBody Todo todo) {
        return this.todoRepository.update(id, todo);
    }
}
