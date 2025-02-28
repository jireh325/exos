package divdev.sn.todo_list.application.port.in;
import java.util.Optional;

import divdev.sn.todo_list.domain.model.Todo;

public interface GetOneTodo {

    Optional<Todo> getOne(String id);
}
