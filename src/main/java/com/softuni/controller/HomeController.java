package com.softuni.controller;

import com.softuni.entity.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("operator", "+");
		model.addAttribute("view", "views/calculatorForm");
		return "base-layout";
	}

	@PostMapping("/")
	public String calculate(@RequestParam(name = "leftOperand") String num1,
							@RequestParam(name="rightOperand") String num2,
							@RequestParam(name = "operator") String operator,
							Model model){
		Double leftOperand = Double.parseDouble(num1);
		Double rightoperand = Double.parseDouble(num2);

		Calculator calculator = new Calculator(leftOperand, rightoperand, operator);
		double result = calculator.calculateResult();

		model.addAttribute("view", "views/calculatorForm");
		model.addAttribute("operator", calculator.getOperator());
		model.addAttribute("leftOperand", calculator.getLeftOperand());
		model.addAttribute("rightOperand", calculator.getRightOperand());
		model.addAttribute("result", result);
		return "base-layout";

	}
}
