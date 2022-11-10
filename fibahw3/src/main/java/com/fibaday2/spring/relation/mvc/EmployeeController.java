package com.fibaday2.spring.relation.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fibaday2.spring.configuration.MyBean;
import com.fibaday2.spring.relation.entity.Employee;
import com.fibaday2.spring.relation.repository.EmployeeRepository;

@Controller
@RequestMapping("/sports")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private MyBean myBean;
	@GetMapping("/employees/bydepartment")
	@ResponseBody
	
	public String getEmployeesByDepartment() {
		System.out.println("Çekirdek " +myBean.getMyLong()+ " "+myBean.getMyString()+ " "+ myBean.getMyDouble());
		long departmentId=2;
		List<Employee> employees =employeeRepository.findAllByTeamId(departmentId);
		double totalScore=0;
		for(Employee employee : employees) {
			System.out.println(employee.getEmployeeId()+" "
					+employee.getEmployeeName()+" "
					+employee.getMonthlySalary());
			totalScore+=employee.getMonthlySalary();
		}
		double monthlySalary = totalScore/employees.size();
		return "Ortalama Çentik: "+monthlySalary;
	}
	

}
