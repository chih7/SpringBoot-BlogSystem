package com.mijack.sbbs.repository;

import com.mijack.sbbs.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog,Long>{
}
