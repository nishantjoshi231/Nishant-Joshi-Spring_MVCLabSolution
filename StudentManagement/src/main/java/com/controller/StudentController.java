package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.entity.Student;
import com.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping("/list")
	public String listStudent(Model theModel) {
		List<Student> student = studentService.findAll();
		theModel.addAttribute("Student", student);

		return "list-student";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("Student", student);
		return "Student-form";

	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model theModel) {
		Student student = studentService.findById(id);
		theModel.addAttribute("Student", student);
		return "Student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		System.out.println(id);
		Student student;
		if (id != 0) {
			student = studentService.findById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		} else
			student = new Student(name, department, country);
		studentService.save(student);
		return "redirect:/students/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		studentService.deleteById(id);
		return "redirect:/students/list";
	}

}
