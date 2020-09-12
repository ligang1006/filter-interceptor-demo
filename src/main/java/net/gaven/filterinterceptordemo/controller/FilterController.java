package net.gaven.filterinterceptordemo.controller;

import net.gaven.filterinterceptordemo.wervice.IFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: lee
 * @create: 2020-09-12 16:21
 **/
@RestController
@RequestMapping("/api/v1/filter")
public class FilterController {
    @Autowired
    IFilterService filterService;

    @GetMapping("/test")
    public Object filter(HttpServletRequest request) {
        String name = request.getHeader("name");
        String result = (String) filterService.loginTest(name);
        return result;
    }
}
