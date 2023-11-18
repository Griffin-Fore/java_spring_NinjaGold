package com.griffinfore.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@RequestMapping("/")
	public String ninjaPage(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("adventurersLog") == null) {
			ArrayList<String> adventurersLog = new ArrayList<>();
			session.setAttribute("adventurersLog", adventurersLog);
		}
		Integer gold = (Integer)session.getAttribute("gold");
		if(gold < -50) {
			return "redirect:/debt";
		}
		return "index.jsp";
	}
	
	@RequestMapping("/farm")
	public String farmRoute(HttpSession session) {
		Random random = new Random();
		int farmGold = random.nextInt(11) +10;
		int currentGold = (int) session.getAttribute("gold");
		int newGoldTotal = currentGold + farmGold;
		session.setAttribute("gold", newGoldTotal);
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy h:mma");
		String formattedDate = dateFormat.format(currentDate);
		String farmLog = "You visited a farm and earned " + farmGold + " gold. (" + formattedDate + ")";
		ArrayList<String> protoLog = (ArrayList<String>) session.getAttribute("adventurersLog");
		int maxLogs = 5;
		int currentLogSize = protoLog.size();
		if(currentLogSize >= maxLogs) {
			protoLog.remove(currentLogSize - 1);
		}
		protoLog.add(0, farmLog);
		session.setAttribute("adventurersLog", protoLog);
		return "redirect:/";
	}
//	change the gold by the given amount
	
	@RequestMapping("/cave")
	public String caveRoute(HttpSession session) {
		Random random = new Random();
		int caveGold = random.nextInt(6) + 5;
		int currentGold = (int) session.getAttribute("gold");
		int newGoldTotal = currentGold + caveGold;
		session.setAttribute("gold", newGoldTotal);
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy h:mma");
		String formattedDate = dateFormat.format(currentDate);
		String caveLog = "You visted a cave and found " + caveGold + " gold. (" + formattedDate + ")";
		ArrayList<String> protoLog = (ArrayList<String>) session.getAttribute("adventurersLog");
		int maxLogs = 5;
		int currentLogSize = protoLog.size();
		if(currentLogSize >= maxLogs) {
			protoLog.remove(currentLogSize - 1);
		}
		protoLog.add(0, caveLog);
		session.setAttribute("adventurersLog", protoLog);
		return "redirect:/";
	}
	
	@RequestMapping("/house")
	public String houseRoute(HttpSession session) {
		Random random = new Random();
		int houseGold = random.nextInt(4) + 2;
		int currentGold = (int) session.getAttribute("gold");
		int newGoldTotal = currentGold + houseGold;
		session.setAttribute("gold", newGoldTotal);
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy h:mma");
		String formattedDate = dateFormat.format(currentDate);
		String houseLog = "You entered a house and found " + houseGold + " gold. (" + formattedDate + ")";
		ArrayList<String> protoLog = (ArrayList<String>) session.getAttribute("adventurersLog");
		int maxLogs = 5;
		int currentLogSize = protoLog.size();
		if(currentLogSize >= maxLogs) {
			protoLog.remove(currentLogSize - 1);
		}
		protoLog.add(0, houseLog);
		session.setAttribute("adventurersLog", protoLog);		
		return "redirect:/";
	}
	
	@RequestMapping("/quest")
	public String questRoute(HttpSession session) {
		Random random = new Random();
		int questGold = random.nextInt(101) - 50;
		int currentGold = (int) session.getAttribute("gold");
		int newGoldTotal = currentGold + questGold;
		session.setAttribute("gold", newGoldTotal);
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy h:mma");
		String formattedDate = dateFormat.format(currentDate);
		String questLog;
		if(questGold < 0) {
			questLog = "You went on a quest and somehow lost " + (questGold * -1)  + " gold. (" + formattedDate + ")";
		}
		else {
			questLog = "You went on a quest and gained " + questGold + " gold. (" + formattedDate + ")";
		}
		ArrayList<String> protoLog = (ArrayList<String>) session.getAttribute("adventurersLog");
		int maxLogs = 5;
		int currentLogSize = protoLog.size();
		if(currentLogSize >= maxLogs) {
			protoLog.remove(currentLogSize - 1);
		}
		protoLog.add(0, questLog);
		session.setAttribute("adventurersLog", protoLog);
		return "redirect:/";
	}
	
	@RequestMapping("/spa")
	public String spaRoute(HttpSession session) {
		Random random = new Random();
		int spaGold = random.nextInt(16) + 5;
		int newSpaGold = spaGold * -1;
		int currentGold = (int) session.getAttribute("gold");
		int newGoldTotal = currentGold + newSpaGold;
		session.setAttribute("gold", newGoldTotal);
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy h:mma");
		String formattedDate = dateFormat.format(currentDate);
		String spaLog = "You visted a spa and spent " + spaGold + ". (" + formattedDate + ")";
		ArrayList<String> protoLog = (ArrayList<String>) session.getAttribute("adventurersLog");
		int maxLogs = 5;
		int currentLogSize = protoLog.size();
		if(currentLogSize >= maxLogs) {
			protoLog.remove(currentLogSize -1);
		}
		protoLog.add(0,spaLog);
		session.setAttribute("adventurersLog", protoLog);
		return "redirect:/";
	}
	
	@RequestMapping("/clear")
	public String clearSession(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping("/debt")
	public String debtRender(HttpSession session) {
		int owed = (int) session.getAttribute("gold");
		int owedGold = owed * -1;
		session.setAttribute("owedGold", owedGold);
		return "debt.jsp";
	}
}
