package divdev.sn.todo_list.infrastructure.adapter.out.jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import divdev.sn.todo_list.infrastructure.adapter.out.jpa.EntityJpa;

@Repository
public interface TodoJpaRepository extends JpaRepository<EntityJpa, Long> {

}
