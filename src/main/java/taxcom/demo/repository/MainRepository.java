package taxcom.demo.repository;

import org.springframework.data.repository.CrudRepository;
import taxcom.demo.domain.MainData;

public interface MainRepository extends CrudRepository<MainData, Integer> {
}
