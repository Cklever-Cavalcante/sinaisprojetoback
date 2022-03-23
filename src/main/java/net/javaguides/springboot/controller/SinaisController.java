package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Empresas;
import net.javaguides.springboot.repository.EmpresasRepository;


/*===Conexão com o FrontEnd em React Js*/
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class SinaisController {

	@Autowired
	private EmpresasRepository empresasRepository;
	

/*========================Metodos Listar============================================*/	
	
	// Listar todos os Empresas
		@GetMapping("/empresas")
		public List<Empresas> getAllEmpresas(){
			return empresasRepository.findAll();
		}
	
/*=========================Metodos Criar============================================*/	
	
	// Criar novo Empresas rest api
		@PostMapping("/empresas")
		public Empresas createEmpresas(@RequestBody Empresas empresas) {
			return empresasRepository.save(empresas);
		}
		
/*==============================Metodos Listar pelo Id======================================================================*/	
		
	// Listar Empresas pelo id rest api
		@GetMapping("/empresas/{id_empresa}")
		public ResponseEntity<Empresas> getEmpresasById(@PathVariable Long id_empresa) {
			Empresas empresas = empresasRepository.findById(id_empresa)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id_empresa));
			return ResponseEntity.ok(empresas);
		}
			
/*========================Metodos Atualizar=========================================*/	
		
	// Atualizar Empresas rest api
	
		@PutMapping("/empresas/{id_empresa}")
		public ResponseEntity<Empresas> updateEmpresas(@PathVariable Long id_empresa, @RequestBody Empresas empresasDetails){
			Empresas empresas = empresasRepository.findById(id_empresa)
					.orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada :" + id_empresa));
			
			empresas.setNomeEmpresa(empresasDetails.getNomeEmpresa());
			empresas.setNomeRespo(empresasDetails.getNomeRespo());
			empresas.setTelefone(empresasDetails.getTelefone());
			empresas.setEmail(empresasDetails.getEmail());
			empresas.setComentarios(empresasDetails.getComentarios());
			
			Empresas updatedEmpresas = empresasRepository.save(empresas);
			return ResponseEntity.ok(updatedEmpresas);
		}
			
/*=============================Metodos Deletar========================================================================*/	
		
	// Deletar Empresas rest api
		@DeleteMapping("/empresas/{id_empresa}")
		public ResponseEntity<Map<String, Boolean>> deleteEmpresas(@PathVariable Long id_empresa){
			Empresas empresas = empresasRepository.findById(id_empresa)
					.orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada :" + id_empresa));
			
			empresasRepository.delete(empresas);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
			
}
