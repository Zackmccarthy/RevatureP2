package com.example.web;

import com.example.entity.Menu;
import com.example.repository.MenuRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

    private MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/menu"
    )
    public ModelAndView getMenu() {
        Iterable<Menu> menu = menuRepository.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("entire-menu", menu);
        mav.setViewName("menu-view");
        return mav;
    }
}
