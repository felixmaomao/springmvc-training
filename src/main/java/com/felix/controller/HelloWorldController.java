package com.felix.controller;

import com.felix.entity.Owner;
import com.felix.entity.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloWorldController {

    //normal patterns
    @RequestMapping("/sayHello")
    public  String hello(Model model){
        model.addAttribute("user","felix");
        return "index";
    }

    // uri template patterns
    @RequestMapping(path = "owners/{ownerId}",method = RequestMethod.GET)
    public String findOwner(@PathVariable String ownerId,Model model){
        // do some logic to find the owner by id
        Owner owner=new Owner();
        owner.setId(ownerId);
        owner.setName("felix");
        owner.setSex("male");
        model.addAttribute("owner",owner);
        return "displayOwner";
    }

    @RequestMapping(path = "owners/{ownerId}/pets/{petId}",method = RequestMethod.GET)
    public String findOwner2(@PathVariable Map<String,String> map, Model model){
        Owner owner=new Owner();
        owner.setId(map.get("ownerId"));
        owner.setName("felix");
        owner.setSex("male");
        Pet pet=new Pet();
        pet.setPetId(map.get("petId"));
        pet.setName("wangcai");
        owner.setPets(Arrays.asList(pet));
        model.addAttribute("owner",owner);
        return "displayOwner";
    }

    //path patterns
    @RequestMapping("owners/*/dog")
    public String findOwner3(){
        return "normal";
    }

    //suffix patterns

    //consumable media types

    //producible media

    //  @ResponseEntity


    //Binding request parameters to method parameters with @RequestParam
    @RequestMapping("/findOwner4")
    public String findOwner4(@RequestParam("petName") String petName,Model model){
       Pet pet=new Pet();
       pet.setName(petName);
       pet.setPetId("123");
       model.addAttribute("pet",pet);
       return "pet";
    }

    //model map modelMap  they are the same object
    @RequestMapping(path = "/findOwner5")
    public String findOwner5(Model model, Map map, ModelMap modelMap){
        model.addAttribute("foo","data from model");
        map.put("bar","data from map");
        modelMap.put("baz","data from modelMap");
        return "fooBarBaz";
    }

    // @ResponseBody将 返回结果直接输出到response中，而不是装到一个model中，或者解析成一个view
    //不过需要一个 converter 将对象转化成json或者xml输出
    @RequestMapping(path = "/findOwner6")
    @ResponseBody
    public Object findOwner6() {
        Pet pet=new Pet();
        pet.setName("wangcai");
        pet.setPetId("123");
        return pet;
    }

    //@ModelAttribute on methods usage
    @ModelAttribute
    public void populateModel(Model model){
        model.addAttribute("company","com.felix");
    }

    @ModelAttribute("selfPet")
    public Pet addPet(){
        Pet pet=new Pet();
        pet.setName("happiness");
        pet.setPetId("123");
        return pet;
    }


}
