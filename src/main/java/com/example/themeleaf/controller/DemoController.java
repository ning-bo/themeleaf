package com.example.themeleaf.controller;

import com.example.themeleaf.entity.DemoEntity;
import com.example.themeleaf.jpa.DemoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author NingBo
 * @create 2018-05-23 9:25
 * @desc 增删改查CRUD
 **/
@RequestMapping(value = "test")
@RestController
public class DemoController {


    @RequestMapping(value = "index")
    public ModelAndView toIndex(){
        return new ModelAndView("view/add.html");
    }
    @RequestMapping(value = "add")
    public ModelAndView toadd(){
        return new ModelAndView("/view/add.html");
    }


    @Autowired
    private DemoJPA demoJPA;


    @RequestMapping(value = "/thymeleaf" , method = RequestMethod.GET)
    public ModelAndView thymeleaf(){

        ModelAndView view = new ModelAndView("/view/thymeleaf.html");

        view.addObject("a","1111");
        view.addObject("b","2222");
        return view;
    }

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public List<DemoEntity> list(){
        //条件查询
        List<DemoEntity> byTitle = demoJPA.findByTitle("ning");
        Optional<DemoEntity> byId = demoJPA.findById(2l);
        DemoEntity demoEntity = byId.get();
        List<Long> objects = new ArrayList<>();
        objects.add(1l);
        objects.add(2l);
        objects.add(3l);
        List<DemoEntity> byIdIn = demoJPA.findByIdIn(objects);
        return demoJPA.findAll();
    }

    @RequestMapping(value = "/save" , method = RequestMethod.GET)
    public DemoEntity save(){
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setTitle("ning");
        demoEntity.setContent("仰天长啸");

        return demoJPA.save(demoEntity);
    }

    @RequestMapping(value = "/delete")
    public List<DemoEntity> delete(@RequestParam(name = "id") Long id){
        demoJPA.deleteById(id);
        return demoJPA.findAll();
    }

    @RequestMapping(value = "/update")
    public List<DemoEntity> update(@RequestParam(name = "id") Long id){
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setId(id);
        demoEntity.setTitle("ningbo");
        demoEntity.setContent("仰天长啸");

        demoJPA.save(demoEntity);

        return demoJPA.findAll();
    }

    //在JPA中写SQL语句
    @RequestMapping(value = "query")
    public List<DemoEntity> findIdLt20(){
        return demoJPA.findIdLt20(new Long(10));
    }

}
