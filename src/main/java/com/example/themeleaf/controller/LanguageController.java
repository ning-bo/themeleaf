package com.example.themeleaf.controller;

import com.example.themeleaf.entity.LanguageEntity;
import com.example.themeleaf.jpa.LanguageJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author NingBo
 * @create 2018-05-29 16:44
 * @desc
 **/
@RestController
@RequestMapping(value = "language")
public class LanguageController {

    @Autowired
    private LanguageJPA languageJPA;

    /**
     * 列表
     * @return
     */
    @RequestMapping(value = "languagelist")
    public ModelAndView languageList(){

        List<LanguageEntity> all = languageJPA.findByStatusNot(4l);

        ModelAndView view = new ModelAndView("/view/index2.html");
        view.addObject("list", all);
        return view;
    }

    /**
     * 保存/修改
     * @param languageEntity
     */
    @RequestMapping(value = "save")
    public void saveLanguage(LanguageEntity languageEntity){

        languageJPA.save(languageEntity);
    }

    public String asd(){
        return "";
    }

}
