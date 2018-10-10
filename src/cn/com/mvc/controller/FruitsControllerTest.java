package cn.com.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.mvc.model.Fruits;
import cn.com.mvc.service.FruitsService;
import cn.com.mvc.service.impl.FruitsServiceImpl;

@Controller
public class FruitsControllerTest{
	private FruitsService fruitsService = new FruitsServiceImpl();

	@RequestMapping("/queryFruitsList")
	public ModelAndView queryFruitsList() {
		List<Fruits> fruitsList = fruitsService.queryFruitsList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("fruitsList", fruitsList);
		modelAndView.setViewName("/WEB-INF/jsp/fruits/fruitsList.jsp");
		return modelAndView;
	}
}
