package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;

	@RequestMapping(value = "/guest/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("GuestbookController.list()");

		List<GuestVo> guestList = guestbookService.exeList();

		model.addAttribute("gList", guestList);

		return "addList";

	}

	@RequestMapping(value = "/guest/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute GuestVo guestVo) {
		System.out.println(guestVo);

		guestbookService.exeWrite(guestVo);

		return "redirect:/guest/list";
	}

	@RequestMapping(value = "/guest/deleteform", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm(@RequestParam("no") int no, Model model) {

		System.out.println("deleteForm()");

		GuestVo guestVo = guestbookService.exeDeleteForm(no);

		model.addAttribute("guestVo", guestVo);

		return "deleteForm";

	}

	@RequestMapping(value = "/guest/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no")int no, @RequestParam("password") String password) {

		guestbookService.exeDelete(no, password);
		
		return "redirect:/guest/list";
	}
}
