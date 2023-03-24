package org.liang.demo.controller;

import org.liang.demo.dao.ClassAlphaDao;
import org.liang.demo.model.ClassAlpha;

@RestController("test")
public class TestController {
    @Resource
    private ClassAlphaDao classAlphaDao;

    @RequestMapping("/put")
    public String put(ClassAlpha classAlpha){
        int result = classAlphaDao.put(classAlpha);
        return "result:" + result;
    }
}
