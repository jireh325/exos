package divdev.sn.todo_list.application.port.in;

import divdev.sn.todo_list.domain.model.Todo;

public interface UpdateTodo {

    Todo update(String id, Todo todo);
}
