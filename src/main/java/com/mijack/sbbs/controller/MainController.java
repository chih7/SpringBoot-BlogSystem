package com.mijack.sbbs.controller;

import com.mijack.sbbs.component.Pagination;
import com.mijack.sbbs.model.Blog;
import com.mijack.sbbs.model.Tag;
import com.mijack.sbbs.model.User;
import com.mijack.sbbs.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author Mr.Yuan
 * @since 2017/8/17
 */
@Controller
public class MainController {
    @Autowired
    MainService mainService;
    public static final int DEFAULT_HOT_BLOG_SIZE = 5;
    public static final int DEFAULT_HOT_USER_SIZE = 5 * 2;
    public static final int DEFAULT_HOT_TAG_SIZE = 4 * 3;
    public static final int DEFAULT_BLOG_SIZE_PRE_PAGE = 10;
    public static final int DEFAULT_BLOG_PAGE_OFFSET = 5;

    @GetMapping({"/", "/index.html"})
    public ModelAndView index(@RequestParam(value = "pageIndex", required = false, defaultValue = "1") int pageIndex,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "" + DEFAULT_BLOG_SIZE_PRE_PAGE) int pageSize) {
        ModelAndView modelAndView = new ModelAndView("index");
        Page<Blog> hotBlogPage = mainService.listHotBlog(new PageRequest(0, DEFAULT_HOT_BLOG_SIZE));
        Page<User> hotUserPage = mainService.listHotUser(new PageRequest(0, DEFAULT_HOT_USER_SIZE));
        Page<Tag> hotTagPage = mainService.listHotTag(new PageRequest(0, DEFAULT_HOT_TAG_SIZE));
        Page<Blog> blogPage = mainService.listNewBlog(new PageRequest(pageIndex - 1, pageSize));
        int firstPage = Math.max(1, pageIndex - DEFAULT_BLOG_PAGE_OFFSET);
        int endPage = Math.max(1, Math.min(blogPage.getTotalPages(), pageIndex + DEFAULT_BLOG_PAGE_OFFSET));
        Pagination pagination = new Pagination(
                pageSize == DEFAULT_BLOG_SIZE_PRE_PAGE ?
                        "index.html?pageIndex={pageIndex}" :
                        ("index.html?pageIndex={pageIndex}&pageSize=" + pageSize)
                , firstPage//首页页码
                , endPage//末页页码
                , pageIndex//当前页页码
                , blogPage.isFirst()//是否为首页
                , blogPage.isLast()//是否为末页
        );
        // 最热博客
        modelAndView.addObject("hotBlogs", hotBlogPage.getContent());
        // 最热用户
        modelAndView.addObject("hotUsers", hotUserPage.getContent());
        // 最热标签
        modelAndView.addObject("hotTags", hotTagPage.getContent());
        // 主页的博客
        modelAndView.addObject("blogs", blogPage.getContent());
        // 分页数据
        modelAndView.addObject("pagination", pagination);
        return modelAndView;
    }

    /**
     * 登录用户界面
     *
     * @return
     */
    @GetMapping({"login.html"})
    @PostMapping({"login"})
    public String loginPage(Authentication authentication) {
        return (authentication != null && authentication.isAuthenticated()) ? "redirect:/" : "login";
    }

    @GetMapping({"/register.html"})
    public String register() {
        return "register";
    }
}
