package io.kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.FavoriteJobPostingService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.FavoriteJobPosting;

@RestController
@RequestMapping("/api/favoriteJobPostings")
@CrossOrigin
public class FavoriteJobPostingsController {

	private FavoriteJobPostingService favoriteJobPostingService;

	@Autowired
	public FavoriteJobPostingsController(FavoriteJobPostingService favoriteJobPostingService) {
		this.favoriteJobPostingService = favoriteJobPostingService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody FavoriteJobPosting favoriteJobPosting) {
		return favoriteJobPostingService.add(favoriteJobPosting);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody FavoriteJobPosting favoriteJobPosting) {
		return favoriteJobPostingService.delete(favoriteJobPosting);
	}

	@GetMapping("/getAll")
	public DataResult<List<FavoriteJobPosting>> getAll() {
		return favoriteJobPostingService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<FavoriteJobPosting> getById(@RequestParam int id) {
		return favoriteJobPostingService.getById(id);
	}

	@GetMapping("/getAllByCandidateId")
	public DataResult<List<FavoriteJobPosting>> getAllByCandidateId(@RequestParam int candidateId) {
		return favoriteJobPostingService.getAllByCandidateId(candidateId);
	}

	@GetMapping("/getAllByCandidateIdSortedByDateOfAddToFavorites")
	public DataResult<List<FavoriteJobPosting>> getAllByCandidateIdSortedByDateOfAddToFavorites(@RequestParam int candidateId) {
		return favoriteJobPostingService.getAllByCandidateIdSortedByDateOfAddToFavorites(candidateId);
	}

}