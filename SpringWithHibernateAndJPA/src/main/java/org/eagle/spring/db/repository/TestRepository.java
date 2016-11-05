package org.eagle.spring.db.repository;

import org.eagle.spring.db.entities.TestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/** @NoRepositoryBean is to avoid creation of repository proxy 
 * for intermidate interfaces like CrudRepository.
 * 
 * if we not give @NoRepositoryBean it try to create repository proxy bean for this and 
 * fails.
 * 
 * @author SINGH.BHARAT
 *
 */
public interface TestRepository extends CrudRepository<TestEntity, Long> {

}
