package divdev.sn.todo_list.infrastructure.adapter.out.mongo;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import divdev.sn.todo_list.application.port.out.TodoRepository;
import divdev.sn.todo_list.domain.model.Todo;
import divdev.sn.todo_list.infrastructure.mapper.TodoMapper;

@Repository("todoMongoAdapter")
public class TodoMongoAdapter implements TodoRepository{

    private final TodoMongoRepository todoMongoRepository;
    private final TodoMapper todoMapper;

    public TodoMongoAdapter(TodoMongoRepository todoMongoRepository, TodoMapper todoMapper) {
        this.todoMongoRepository = todoMongoRepository;
        this.todoMapper = todoMapper;
    }


    @Override
    public Todo save(Todo todo){
        EntityMongo entityTodo = this.todoMapper.toEntityMongo(todo);
        return this.todoMapper.fromMongotoModel(this.todoMongoRepository.save(entityTodo));
    }

    @Override
    public List<Todo> findAll(){
        return this.todoMongoRepository.findAll().stream()
            .map(this.todoMapper::fromMongotoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Todo> findById(String id){
        return this.todoMongoRepository.findById(id).map(this.todoMapper::fromMongotoModel);
    }

    @Override
    public Todo update(String id, Todo todo){
        EntityMongo todoExist = this.todoMongoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tâche non trouvée avec l'ID : " + id));
        todoExist.setTitle(this.todoMapper.toEntityMongo(todo).getTitle());
        todoExist.setDescription(this.todoMapper.toEntityMongo(todo).getDescription());

        return this.todoMapper.fromMongotoModel(this.todoMongoRepository.save(todoExist));
    }

    @Override
    public void delete(String id){
        this.todoMongoRepository.deleteById(id);
    }

}
