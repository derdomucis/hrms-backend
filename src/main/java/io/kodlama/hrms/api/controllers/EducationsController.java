package io.kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.EducationService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Education;

@RestController
@RequestMapping("/api/educations")
public class EducationsController {

	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		this.educationService = educationService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Education education) {
		return educationService.add(education);
	}

	@PostMapping("/update")
	public Result update(@RequestBody Education education) {
		return educationService.update(education);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody Education education) {
		return educationService.delete(education);
	}

	@GetMapping("/getAll")
	public DataResult<List<Education>> getAll() {
		return educationService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<Education> getById(@RequestParam int id) {
		return educationService.getById(id);
	}

	@GetMapping("/getAllByResumeIdSortedByGraduationDate")
	public DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(@RequestParam int resumeId) {
		return educationService.getAllByResumeIdSortedByGraduationDate(resumeId);
	}

}
