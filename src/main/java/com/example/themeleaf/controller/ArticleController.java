package com.example.themeleaf.controller;

import com.example.themeleaf.common.Enum.StatusEnum;
import com.example.themeleaf.entity.ArticleEntity;
import com.example.themeleaf.jpa.ArticleJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * @author NingBo
 * @create 2018-05-29 10:07
 * @desc
 **/
@RestController
@RequestMapping(value = "article")
public class ArticleController {

    @Autowired
    private ArticleJPA articleJPA;

    @RequestMapping(value = "add_index")
    public ModelAndView toadd(){
        return new ModelAndView("/view/add.html");
    }

    /**
     * 首页列表
     * @param name
     * @return
     */
    @RequestMapping(value = "list_index")
    public ModelAndView listIndex(String name){
        ModelAndView view = new ModelAndView("/view/index.html");

        List<ArticleEntity> list;

        if(StringUtils.equals(name,"ning")){
            list = articleJPA.findAll();
        }else {
            list = articleJPA.findByStatus(StatusEnum.PUBLISH.getKey());
        }
        view.addObject("list",list);
        return view;
    }

    /**
     * 详情页面、修改页面
     * @param id
     * @return
     */
    @RequestMapping(value = "article_details_index")
    public ModelAndView ArticleDetails(@RequestParam("id")Long id){

        ModelAndView view = new ModelAndView("/view/index.html");

        Optional<ArticleEntity> byId = articleJPA.findById(id);

        view.addObject("article" ,byId.get());

        return view;
    }

    /**
     * 保存
     * @param articleEntity
     */
    @RequestMapping(value = "save_article")
    public void saveArticle(ArticleEntity articleEntity){
        articleJPA.save(articleEntity);
    }
}
