package org.sample.customermanager.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * 특정고객관리 BranchRepository 도메인
 * @author 이승호
 * @version 1.0
 */

public interface BranchRepository extends CrudRepository<Branch, Long> {
}
