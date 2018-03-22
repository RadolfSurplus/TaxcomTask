package taxcom.demo.repository;

import org.springframework.data.repository.CrudRepository;
import taxcom.demo.domain.MainData;

import javax.transaction.Transactional;

@Transactional
public interface MainRepository extends CrudRepository<MainData, Integer> {
}
