package au.com.telstra.simcardactivator.repository;

import au.com.telstra.simcardactivator.foundation.SimCardRecord;
import org.springframework.data.repository.CrudRepository;

public interface SimCardRepository extends CrudRepository<SimCardRecord, Long> {

}