package cn.cjtblog.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.cjtblog.service.NodeService;

@Controller
public class HtmlController {
	private static Logger logger = LoggerFactory
			.getLogger(HtmlController.class);
	@Autowired
	private NodeService nodeService;
	
	@RequestMapping(value="/footer.htm", method = RequestMethod.GET)
	String getFooter(Model model) {
		logger.info("gettingfooter");
		return "footer";
	}


	@RequestMapping(value="/addNode.htm", method = RequestMethod.GET)
	String addNode(Model model) {
		return "addNode";
	}
	
	@RequestMapping(value="/addData.htm", method = RequestMethod.GET)
	String addData(Model model) {
		model.addAttribute("nodes",nodeService.getAllNodes());
		return "addData";
	}
	
	@RequestMapping(value="/addNode.htm", method = RequestMethod.POST)
	String addNode(@RequestParam Map<String,Object> fieldMap) {
		
		logger.info(fieldMap.toString());
	
		nodeService.addNode(fieldMap);
		return "redirect:index.htm";
	}
	
	@RequestMapping(value="/index.htm",method = RequestMethod.GET)
	String getIndex(Model model) {
		model.addAttribute("nodes",nodeService.getAllNodes());

		return "index";
	}
	

}
