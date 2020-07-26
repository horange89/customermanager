package org.sample.customermanager.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * 특정고객관리 Account Repository
 * @author 이승호
 * @version 1.0
 */

public interface AccountRepository extends CrudRepository<Account, Long> {
}
