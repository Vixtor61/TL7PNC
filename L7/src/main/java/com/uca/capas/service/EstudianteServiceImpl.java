package com.uca.capas.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.EstudianteDao;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.dto.EstudianteDTO;
import com.uca.capas.repositories.EstudianteRepo;

@Service
public class EstudianteServiceImpl implements EstudianteService {
	@Autowired
	EstudianteRepo estudianteRepo;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		return estudianteRepo.findAll();
	}
	
	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.getOne(code);
	}
	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteRepo.save(estudiante);
	}
	@Override
	@Transactional
	public void update(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		if(estudianteRepo.existsById(estudiante.getCodigoEstudiante())) {
			estudianteRepo.save(estudiante);
			
		}
		
	}
	
	
	@Override
	@Transactional
	public void delete(Integer codigoEstudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteRepo.deleteById(codigoEstudiante);
	}
	@Override
	public List<Estudiante> filtrarPor(String cadena) throws DataAccessException {
		// TODO Auto-generated method stub

		return estudianteRepo.findByNombre(cadena);
	}
	
	@Override
	public List<Estudiante> lastnameStartingWith(String cadena) throws DataAccessException {
		// TODO Auto-generated method stub
	return estudianteRepo.findByApellidoStartingWith(cadena);
	}
	
	
	@Override
	public List<EstudianteDTO> pruebaDTO() throws DataAccessException {
		// TODO Auto-generated method stub
		 List<EstudianteDTO> estudiantes = estudianteRepo.pruebaDTO().stream().map(obj->{
			 EstudianteDTO e = new EstudianteDTO();
			 e.setNombre(obj[0].toString());
			 e.setApellido(obj[1].toString());
			 
			 return e;
		 }).collect(Collectors.toList());
		 return estudiantes;
	
	}

}
