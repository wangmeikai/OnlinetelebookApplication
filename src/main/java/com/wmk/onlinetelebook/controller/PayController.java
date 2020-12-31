package com.wmk.onlinetelebook.controller;


import com.wmk.onlinetelebook.common.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PayController {

    @GetMapping({"/pay"})
    @ResponseBody
    public String pay(@RequestParam("money") int money) {
        System.out.println("zhifu");
        return "支付"+money+"元成功";
    }

    @PostMapping({"/pay"})
    @ResponseBody
    public Result<String> pay1(@RequestBody Map<String, Integer> map) {
        return new Result<>(200,"请求成功","支付"+map.get("money")+"元成功");
    }
}
