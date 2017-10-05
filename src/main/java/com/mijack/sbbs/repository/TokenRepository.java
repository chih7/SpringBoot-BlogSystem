package com.mijack.sbbs.repository;

import com.mijack.sbbs.model.Token;
import com.mijack.sbbs.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends PagingAndSortingRepository<Token,Long>{
User findByUser(User user);

    User findByToken(String token);
}
