package taxcom.demo.repository;

import org.springframework.data.repository.CrudRepository;
import taxcom.demo.domain.MainData;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
public interface MainRepository extends CrudRepository<MainData, Integer> {

    MainData findById(UUID id);
}
