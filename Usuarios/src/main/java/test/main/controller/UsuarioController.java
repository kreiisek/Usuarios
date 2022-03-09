package test.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.main.DTO.UsuarioDTO;
import test.main.entity.Usuario;
import test.main.reposDAO.IUsuarioDAO;

//Annotaciones API RestFul

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	IUsuarioDAO user;
	
	Usuario Upusr = null;

	// GET
	@GetMapping
	public List<Usuario> SelectAll() {
		return user.findAll();
	}

	// GET / parametros
	@GetMapping("/{noEmpleado}")
	public ResponseEntity<List<Usuario>> SelectBy(@PathVariable("noEmpleado") String noEmpleado) {
		List<Usuario> list = null;
		if (noEmpleado != null) {
			list = user.findBynoEmpleado(noEmpleado);

			if (list.size() > 0) {
				return new ResponseEntity<>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
			}
		}
		return new ResponseEntity<>(user.findAll(), HttpStatus.OK);
	}

	// Method Post
	@PostMapping
	public ResponseEntity<Integer> AddUser(@RequestBody UsuarioDTO UserRequest) {

		if (UserRequest != null) {
			Usuario adduser = new Usuario(UserRequest.getNoEmpleado(), UserRequest.getNombreCompleto(),
					UserRequest.getFechaNacimiento(), UserRequest.getCelular(), UserRequest.getEstatus());
			if (adduser != null) {
				user.save(adduser);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

	}



	@PutMapping("/{noEmpleado}")
	public ResponseEntity<String> UpdateUser(@PathVariable("noEmpleado") String noEmpleado,
			@RequestBody UsuarioDTO UserRequest) {

		Upusr = new Usuario();
		List<Usuario> list = user.findBynoEmpleado(noEmpleado);
		Upusr.setNoEmpleado(list.get(0).getNoEmpleado());
		Upusr.setNombreCompleto(list.get(0).getNombreCompleto());
		Upusr.setFechaNacimiento(list.get(0).getFechaNacimiento());
		Upusr.setCelular(list.get(0).getCelular());
		Upusr.setEstatus(list.get(0).getEstatus());

		Optional<Usuario> Opusr = Optional.of(Upusr);
		if (Upusr != null) {
			Opusr.get().setNombreCompleto(UserRequest.getNombreCompleto());
			Opusr.get().setFechaNacimiento(UserRequest.getFechaNacimiento());
			Opusr.get().setCelular(UserRequest.getCelular());
			//Opusr.get().setEstatus(UserRequest.getEstatus());
			Usuario resp = user.save(Opusr.get());

			if (resp != null) {
				return new ResponseEntity<>(resp.getNoEmpleado(), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/status/{noEmpleado}")
	public ResponseEntity<String> UpdateStatus(@PathVariable("noEmpleado") String noEmpleado) {
		
		Upusr = new Usuario();
		
		List<Usuario> list = null;
		
		list = user.findBynoEmpleado(noEmpleado);

		if (list != null) {
			
			Upusr.setNoEmpleado(noEmpleado);
			Upusr.setNombreCompleto(list.get(0).getNombreCompleto());
			Upusr.setFechaNacimiento(list.get(0).getFechaNacimiento());
			Upusr.setCelular(list.get(0).getCelular());
			Upusr.setEstatus(list.get(0).getEstatus());
			
			if ( Upusr.getEstatus().equals("0")) {
				
				Upusr.setEstatus("1");
				//user.delete(Upusr);
				Usuario resp = user.save(Upusr);
				
				if (resp != null) {
					return new ResponseEntity<>(resp.getNoEmpleado(), HttpStatus.CREATED);
				}
			}else {
				Upusr.setEstatus("0");
				//user.delete(Upusr);
				Usuario resp = user.save(Upusr);
				if (resp != null) {
					return new ResponseEntity<>(resp.getNoEmpleado(), HttpStatus.CREATED);
				}
			}
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
