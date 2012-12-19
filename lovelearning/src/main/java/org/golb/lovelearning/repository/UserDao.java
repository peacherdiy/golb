package org.golb.lovelearning.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.golb.lovelearning.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}
