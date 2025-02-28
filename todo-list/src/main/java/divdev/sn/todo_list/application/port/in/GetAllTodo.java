package divdev.sn.todo_list.application.port.in;

import java.util.List;

import divdev.sn.todo_list.domain.model.Todo;

public interface GetAllTodo {

    List<Todo> getAll();
}
