package com.esprit.examen.controllers;

import java.util.List;

import com.esprit.examen.entities.dto.OperateurDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.services.IOperateurService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "Gestion des opérateurs")
@RequestMapping("/operateur")
@CrossOrigin("*")
public class OperateurController {

	@Autowired
	IOperateurService operateurService;
	
	@GetMapping("/retrieve-all-operateurs")
	@ResponseBody
	public List<Operateur> getOperateurs() {
		return operateurService.retrieveAllOperateurs();
	}

	@GetMapping("/retrieve-operateur/{operateur-id}")
	@ResponseBody
	public Operateur retrieveOperateur(@PathVariable("operateur-id") Long operateurId) {
		return operateurService.retrieveOperateur(operateurId);
	}

	@PostMapping("/add-operateur")
	@ResponseBody
	public Operateur addOperateur(@RequestBody OperateurDTO op) {
		Operateur opp = new Operateur();
		opp.setIdOperateur(op.getIdOperateur());
		opp.setNom(op.getNom());
		opp.setPassword(op.getPassword());
		opp.setPrenom(op.getPrenom());
		return operateurService.addOperateur(opp);
	}

	@DeleteMapping("/remove-operateur/{operateur-id}")
	@ResponseBody
	public void removeOperateur(@PathVariable("operateur-id") Long operateurId) {
		operateurService.deleteOperateur(operateurId);
	}

	@PutMapping("/modify-operateur")
	@ResponseBody
	public Operateur modifyOperateur(@RequestBody OperateurDTO op) {
		Operateur opp = new Operateur();
		opp.setIdOperateur(op.getIdOperateur());
		opp.setNom(op.getNom());
		opp.setPassword(op.getPassword());
		opp.setPrenom(op.getPrenom());
		return operateurService.updateOperateur(opp);
	}

	
}
