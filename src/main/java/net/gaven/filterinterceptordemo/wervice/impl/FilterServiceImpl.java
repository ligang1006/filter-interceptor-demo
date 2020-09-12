package net.gaven.filterinterceptordemo.wervice.impl;

import net.gaven.filterinterceptordemo.wervice.IFilterService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: lee
 * @create: 2020-09-12 16:53
 **/
@Service
public class FilterServiceImpl implements IFilterService {
    /**
     * @return
     */
    @Override
    public Object loginTest(String name) {
        String result = name + "login success";
        return result;
    }
}
