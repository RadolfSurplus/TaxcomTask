package taxcom.demo.repository;

import org.springframework.data.repository.CrudRepository;
import taxcom.demo.domain.MainDataAddition;

public interface MainAdditionsRepository extends CrudRepository<MainDataAddition, Integer> {
}
