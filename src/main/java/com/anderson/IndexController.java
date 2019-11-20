package com.anderson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Anderson on 18/09/2019.
 */

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
