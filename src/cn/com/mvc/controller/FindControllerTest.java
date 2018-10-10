package cn.com.mvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.mvc.model.Fruits;
import cn.com.mvc.service.FruitsService;
import cn.com.mvc.service.impl.FruitsServiceImpl;
import cn.com.mvc.vo.ListQryModel;
import cn.com.mvc.vo.MapQryModel;

@Controller
public class FindControllerTest {
	private FruitsService fruitsService = new FruitsServiceImpl();
	
	@RequestMapping("queryFruitsByCondition")
	public ModelAndView queryFruitsByCondition(Fruits fruits) {
		List<Fruits> fruitsList= null;
		if(fruits == null ||
				(StringUtils.isEmpty(fruits.getName()) && StringUtils.isEmpty(fruits.getProducting_area()))) {
			fruitsList = fruitsService.queryFruitsList();
		}else {
			fruitsList = fruitsService.queryFruitsByCondition(fruits);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("fruitsList",fruitsList);
		mv.setViewName("/WEB-INF/jsp/fruits/findFruits.jsp");
		return mv;
	}
	
	@RequestMapping("fruitsArrayTest")
	public void fruitsArrayTest(int[] fids,HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		for (int i = 0; i < fids.length; i++) {
			System.out.println("fids["+i+"]="+fids[i]);
		}
		resp.sendRedirect("queryFruitsByCondition.action");
//		req.getRequestDispatcher("/WEB-INF/jsp/fruits/findFruits.jsp").forward(req, resp);
	}
	
	@RequestMapping("fruitsListTest")
	public void fruitsListTest(ListQryModel listQryModel,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		List<Fruits> fruitList = listQryModel.getFruitList();
		for (int i = 0; i < fruitList.size(); i++) {
			System.out.println("fruitList["+i+"].name="+fruitList.get(i).getName());
		}
		resp.sendRedirect("queryFruitsByCondition.action");
	}
	
	@RequestMapping("fruitsMapTest")
	public void fruitsMapTest(MapQryModel mapQryModel,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		Map<String, Object> fruitsMap = mapQryModel.getFruitsMap();
		for (String key: fruitsMap.keySet()) {
			System.out.println("fruitList["+key+"]="+fruitsMap.get(key));
		}
		resp.sendRedirect("queryFruitsByCondition.action");
	}
}
