package divdev.sn.todo_list.infrastructure.adapter.in.soap;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import divdev.sn.todo_list.application.port.in.UseCasePort;
import divdev.sn.todo_list.application.port.out.TodoRepository;
import divdev.sn.todo_list.domain.model.Todo;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(serviceName = "TodoSoap")
@Service
public class TodoSoapService implements UseCasePort {

    private final TodoRepository todoRepository;

    public TodoSoapService(@Qualifier("todoJpaAdapter") TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @WebMethod(operationName = "getAllTodos")
    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @WebMethod(operationName = "getOneTodo")
    @Override
    public Optional<Todo> getOne(@WebParam(name = "id") String id) {
        return todoRepository.findById(id);
    }

    @WebMethod(operationName = "createTodo")
    @Override
    public Todo create(@WebParam(name = "todo") Todo todo) {
        return todoRepository.save(todo);
    }

    @WebMethod(operationName = "updateTodo")
    @Override
    public Todo update(@WebParam(name = "id") String id, @WebParam(name = "todo") Todo todo) {
        return todoRepository.update(id, todo);
    }

    @WebMethod(operationName = "deleteTodo")
    @Override
    public void delete(@WebParam(name = "id") String id) {
        todoRepository.delete(id);
    }
}
