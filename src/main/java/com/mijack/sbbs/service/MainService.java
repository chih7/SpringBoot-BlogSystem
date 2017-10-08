package com.mijack.sbbs.service;


import com.mijack.sbbs.model.Blog;
import com.mijack.sbbs.model.Tag;
import com.mijack.sbbs.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 首页的服务
 */
public interface MainService {
    Page<Blog> listHotBlog(Pageable pageable);

    Page<Blog> listNewBlog(Pageable pageable);

    Page<Tag> listHotTag(Pageable pageable);

    Page<User> listHotUser(Pageable pageable);
}
