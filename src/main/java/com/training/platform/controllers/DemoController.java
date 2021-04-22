package com.training.platform.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
@RestController
@RequestMapping("/demo")

public class DemoController {


    @RequestMapping(value = "/healthcheck")
    public String healthCheck(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
        return "Hello World!";
    }



    @GetMapping(value = "")
    public String showWithParam(@RequestParam String id) { //ข้อมูลมีหรือไม่มีก้ได้ key value ?
        return "Method Get, Function : show, ID : "+ id +" => SHOW data by id on page with query string";
    }

    @PostMapping(value = "") // request body post
    public String create(@RequestBody Map<String,Object> inputs) {
        System.out.println("########### POST Param ###########");
        System.out.println(inputs);

        return "Method POST, Function : create => INSERT data to DB";
    }

    @GetMapping(value = "/{id}") //get path  ระวังง
    public String showWithPath(@PathVariable String id) {
        return "Method Get, Function : show, ID : "+ id +" => SHOW data by id on page with path";
    }

    @PatchMapping(value = "/{id}")
    public String update(@PathVariable String id, @RequestParam Map<String,Object> inputs) {
        System.out.println("########### PATCH Param ###########");
        System.out.println(inputs);

        return "Method PATCH, Function : update => ID : " + id + "UPDATE data to DB";
    }

    @DeleteMapping(value = "/{id}")
    public String destroy(@PathVariable String id)  {
        return "Method DELETE, Function : delete, ID : " + id + " => DELETE data to DB";
    }



}