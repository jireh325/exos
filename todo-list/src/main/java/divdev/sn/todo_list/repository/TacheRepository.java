package divdev.sn.todo_list.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import divdev.sn.todo_list.models.Tache;


public interface TacheRepository extends JpaRepository<Tache, Integer> {

}
