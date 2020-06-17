package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.EstudianteDao;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.dto.EstudianteDTO;
import com.uca.capas.service.EstudianteService;

@Controller
public class MainController {
	@Autowired
	private EstudianteService estudianteService;
	
	
/*
	@RequestMapping("/listado")
	public ModelAndView  initMain(){

				
				
					
		ModelAndView mav = new ModelAndView();
		
		
		List<Estudiante> estudiantes = null;
		try {
			
			estudiantes = estudianteDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		
		mav.setViewName("main");
		

		return mav;
	}
	
	
	@RequestMapping("/inicio")
	public ModelAndView  inicio(){

				
				
					
		ModelAndView mav = new ModelAndView();
		
		
		Estudiante estudiante = new Estudiante();
	
		mav.addObject("estudiante",estudiante);
		
		mav.setViewName("index");
		

		return mav;
	}
	
	@RequestMapping("/guardar")
	public ModelAndView  guardar(@ModelAttribute Estudiante estudiante){

				
				
					
		ModelAndView mav = new ModelAndView();
		
		

		try {
			
			estudianteDAO.insert(estudiante);
		} catch (Exception e) {
			e.printStackTrace();
		}
	//	mav.addObject("estudiantes",estudiantes);
		
		mav.setViewName("index");
		

		return mav;
	}
	
	
	*/
	
	@RequestMapping(value="/mostrarEstudiante",method= RequestMethod.POST)
	public ModelAndView  findOne(@RequestParam(value="codigo") int id){

				
				
					
		ModelAndView mav = new ModelAndView();
		
		
		Estudiante estudiante = new Estudiante();
		try {
			 estudiante = estudianteService.findOne(id);
		
		} catch (Exception e) {
		
			e.printStackTrace();

			
			
		}

				mav.addObject("estudiante",estudiante);
				
				mav.setViewName("estudiante");
				

		 

		return mav;
	}
	
	
	
	
	@RequestMapping("/")
	public ModelAndView Main() {
		
		
		ModelAndView mav = new ModelAndView();
		
		
		List<Estudiante> estudiantes = null;
		try {
			
			estudiantes = estudianteService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		
		mav.setViewName("main");
		

		return mav;
	}
	
	
	
	
	@PostMapping("/dto")
	public ModelAndView  mostrarDTO(){

				
				
					
		ModelAndView mav = new ModelAndView();
		
		
		List<EstudianteDTO> estudiantes = null;
		try {
			
			estudiantes = estudianteService.pruebaDTO();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		
		mav.setViewName("pruebaDTO");
		

		return mav;
	}
	
	@PostMapping("/save")
	public ModelAndView guardar(@Valid @ModelAttribute Estudiante estudiante,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			
			mav.setViewName("agregarEstudiante");
			
		} else {
			estudianteService.save(estudiante);
			List<Estudiante> estudiantes = null;
			try {
				estudiantes = estudianteService.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.addObject("estudiantes",estudiantes);
			mav.setViewName("listaEstudiantes");
			

		}
		
		return mav;
	}
	
	@PostMapping(value = "/update")
	public ModelAndView update(@Valid @ModelAttribute Estudiante estudiante,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			
			mav.setViewName("agregarEstudiante");
			
		} else {
			estudianteService.update(estudiante);
			List<Estudiante> estudiantes = null;
			try {
				estudiantes = estudianteService.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.addObject("estudiantes",estudiantes);
			mav.setViewName("listaEstudiantes");
			

		}
		
		return mav;
	}
	
	@RequestMapping(value = "/borrarEstudiante",method = RequestMethod.POST)
	public ModelAndView  delete(@RequestParam(value = "codigo") int id){

				
				
					
		ModelAndView mav = new ModelAndView();
		
		
		List<Estudiante> estudiantes = null;
		try {
			estudianteService.delete(id);
			estudiantes = estudianteService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		
		mav.setViewName("main");
		

		return mav;
	}
	
	//editStudent
	@RequestMapping(value = "/editStudent",method = RequestMethod.GET)
	public ModelAndView  editstudent(@RequestParam(value = "codigo") int id){

				
				
					
		ModelAndView mav = new ModelAndView();
		
		
		Estudiante estudiantes = new Estudiante();
		try {
			
			estudiantes = estudianteService.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiante",estudiantes);
		
		mav.setViewName("edit");
		

		return mav;
	}
	
	@RequestMapping(value = "/filtrar",method = RequestMethod.GET)
	public ModelAndView  findBy(@RequestParam(value = "nombre") String cadena){

				
				
					
		ModelAndView mav = new ModelAndView();
		
		
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteService.lastnameStartingWith(cadena);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		
		mav.setViewName("main");
		

		return mav;
	}
	
	@GetMapping("/insertarEstudiante")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", new Estudiante());
		mav.setViewName("agregarEstudiante");
		return mav;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}