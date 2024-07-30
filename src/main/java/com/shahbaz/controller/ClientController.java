package com.shahbaz.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shahbaz.entity.Client;
import com.shahbaz.service.IClientService;
import com.shahbaz.util.ClientUtil;
import com.shahbaz.view.ClientExcelView;
import com.shahbaz.view.ClientPDFView;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private IClientService cliService;
	@Autowired
	private ServletContext sc;
	@Autowired
	private ClientUtil util;
	
	@GetMapping("/home")
	public String getHome() {
		
		return "HomeClient";
	}
	
	@GetMapping("/register")
	public String showRegister(Map<String,Object> map) {
		map.put("client", new Client());
		return "ClientRegister";
	}
	
	@PostMapping("/save")
	public String processRegister(@ModelAttribute Client client,RedirectAttributes attrs) {
		Integer id=cliService.saveClient(client);
		attrs.addFlashAttribute("message", "Record got inserted with an id "+id+"");
		return "redirect:all";
	}
	
	@GetMapping("/all")
	public String getView(@PageableDefault(page=0,size=4) @SortDefault(sort="id",direction=Sort.Direction.DESC) Pageable pageable,Map<String,Object> map,@RequestParam(value="clientName",required=false,defaultValue="")String clientName) {
		Page<Client> page=null;
		if("".equals(clientName)) {
			page=cliService.getAllClients(pageable);
		}else {
			page=cliService.findByClientNameContaining(clientName, pageable);
		}
		//Page<Client> page=cliService.getAllClients(pageable);
		map.put("clientList", page.getContent());
		map.put("page", page);
		map.put("count", cliService.getAllCount());
		return "ClientData";
	}
	
	@GetMapping("/delete")
	public String deleteRecord(@RequestParam Integer id,RedirectAttributes attrs) {
		cliService.deleteClient(id);
		attrs.addFlashAttribute("message", "Record with an id "+id+" got deleted from Database successfully");
		return "redirect:all";
	}
	
	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id,Map<String,Object> map) {
		Client client=cliService.getOneClient(id);
		System.out.println(id);
		map.put("client", client);
		return "ClientEdit";
	}
	
	@PostMapping("/update")
	public String processEdit(@ModelAttribute Client client,RedirectAttributes attrs) {
		
		Integer id=cliService.saveClient(client);
		attrs.addFlashAttribute("message", "Record got updated with an id "+id+", successfully");
		return "redirect:all";
	}
	
	@GetMapping("/priority")
	public String pieChartOfPriority() {
		List<Object[]> priorityData=cliService.getPriorityOfWorkAndCount();
		String path=sc.getRealPath("/");
		util.generatePiePriority(path, priorityData);
		return "PriorityChart";
	}
	
	@GetMapping("/type")
	public String pieChartOfType() {
		List<Object[]> typeData=cliService.getTypeOfWorkAndCount();
		String path=sc.getRealPath("/");
		util.generatePieType(path, typeData);
		return "TypeChart";
	}
	
	@GetMapping("/nature")
	public String pieChartOfNature() {
		List<Object[]> natureData=cliService.getNatureOfWorkAndCount();
		String path=sc.getRealPath("/");
		util.generatePieNature(path, natureData);
		return "NatureChart";
	}
	
	@GetMapping("/excel")
	public ModelAndView getExcel() {
		ModelAndView mav=new ModelAndView();
		mav.setView(new ClientExcelView());
		List<Client> clientList=cliService.getAllClients();
		mav.addObject("list", clientList);
		return mav;
	}
	
	@GetMapping("/pdf")
	public ModelAndView getPdf(@RequestParam Integer id) {
		ModelAndView mav=new ModelAndView();
		mav.setView(new ClientPDFView());
		Client client=cliService.getOneClient(id);
		mav.addObject("client", client);
		return mav;
	}
	
	@GetMapping("/validate")
	public @ResponseBody String validateWorkOrderNo(@RequestParam String workOrderNo) {
		String message="";
		if(cliService.isWorkOrderNoExist(workOrderNo)) {
			message="<b>*WORK ORDER NO :"+"'"+workOrderNo+"'"+" ALREADY EXIST.</b>";
		}
		return message;
	}
	
}
