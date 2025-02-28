package divdev.sn.todo_list.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import divdev.sn.todo_list.domain.model.Todo;
import divdev.sn.todo_list.infrastructure.adapter.out.jpa.EntityJpa;
import divdev.sn.todo_list.infrastructure.adapter.out.mongo.EntityMongo;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    @Mapping(target = "id", expression = "java(entity.getId().toString())")
    Todo fromJpatoModel(EntityJpa entity);

    Todo fromMongotoModel(EntityMongo entity);

    @Mapping(target = "id", expression = "java(todo.getId() != null ? Long.valueOf(todo.getId()) : null)")
    EntityJpa toEntityJpa(Todo todo);

    EntityMongo toEntityMongo(Todo todo);
}
