package io.kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.CompanyStaffService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.CompanyStaff;

@RestController
@RequestMapping("/api/companyStaffs")
public class CompanyStaffsController {

	private CompanyStaffService companyStaffService;

	@Autowired
	public CompanyStaffsController(CompanyStaffService companyStaffService) {
		this.companyStaffService = companyStaffService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CompanyStaff companyStaff) {
		return companyStaffService.add(companyStaff);
	}

	@PostMapping("/update")
	public Result update(@RequestBody CompanyStaff companyStaff) {
		return companyStaffService.update(companyStaff);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody CompanyStaff companyStaff) {
		return companyStaffService.delete(companyStaff);
	}

	@GetMapping("/getAll")
	public DataResult<List<CompanyStaff>> getAll() {
		return companyStaffService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<CompanyStaff> getById(@RequestParam int id) {
		return companyStaffService.getById(id);
	}

}
