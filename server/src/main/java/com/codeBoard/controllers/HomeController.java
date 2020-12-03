package com.codeBoard.controllers;

import com.codeBoard.Response.Items;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {

    @RequestMapping(value = "/homepage.html", method = RequestMethod.GET)
    public void handleGet(HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.appendField(Items.VIEW, ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().getPath());
        response.setContentType("application/json");
        response.getWriter().write(jsonObject.toJSONString());
    }
}
