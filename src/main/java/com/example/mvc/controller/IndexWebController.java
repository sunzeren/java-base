package com.example.mvc.controller;

import com.example.constant.GlobalConstant;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ZeRen.
 * @Date: 2020/7/3 13:41
 */
@RestController
public class IndexWebController {


    @GetMapping("/getDeployTime.json")
    public String test() {
        return " This Application Deploy on:" + DateFormatUtils.format(GlobalConstant.APP_DEPLOY_TIME, "yyyy-MM-dd HH:mm:ss");
    }

}
