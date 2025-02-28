package divdev.sn.todo_list.infrastructure.adapter.out.mongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import divdev.sn.todo_list.infrastructure.adapter.out.mongo.EntityMongo;

@Repository
public interface TodoMongoRepository extends MongoRepository<EntityMongo, String>{

}
