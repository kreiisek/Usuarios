package test.main.reposDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import test.main.entity.Usuario;

//Tipo de dato de la Llave primaria
public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {

	List<Usuario> findBynoEmpleado(String noEmpleado );
	
	
}
