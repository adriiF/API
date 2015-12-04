package com.alumnosws.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alumnosws.model.Alumno;
@RestController
public class AlumnosController {
	
	List<Alumno>listaAlu=new ArrayList<Alumno>();

	void cargarAlumnos(){
		
		listaAlu.add(new Alumno(1,"Fernandez","Adri","TSP",21));
		listaAlu.add(new Alumno(2,"Cordoba","Marce","TSP",21));
		listaAlu.add(new Alumno(3,"silva","irma","tsp",21));
		listaAlu.add(new Alumno(4,"Cendra","Antonella","IQ",42));
		listaAlu.add(new Alumno(5,"Lutz","Cecilia","ISI",42));
	}
	@RequestMapping("/alumnos/todos")
	public List<Alumno>buscarTodos(){
		if(listaAlu.size()==0)
			cargarAlumnos();
		return listaAlu;
	}
	@RequestMapping("/alumnos/buscar")
	public List<Alumno>buscarPorAlumno(@RequestParam(value="alumno",defaultValue="null",required=true)String texto){
			List<Alumno>filtro=new ArrayList<>();
			for(Alumno a: listaAlu){
				
				if(a.getApellido().toLowerCase().contains(texto)||
				a.getNombre().toLowerCase().contains(texto.toLowerCase())){
					filtro.add(a);
				}
			}
			return filtro;
		}
	
@RequestMapping("/alumnos/nuevo")
public List<Alumno>nuevoAlumno(
		@RequestParam(value="apellido",defaultValue="null",required=true)String apellido,
		@RequestParam(value="nombre",defaultValue="null",required=true)String nombre,
		@RequestParam(value="carrera",defaultValue="null",required=true)String carrera,
		@RequestParam(value="cantidad",defaultValue="null",required=true)int cantMaterias
		
		){
	if(listaAlu.size()==0)
		cargarAlumnos();
	Alumno alu=new Alumno(listaAlu.size()+1, apellido, nombre,carrera,cantMaterias);
	listaAlu.add(alu);
	return listaAlu;
}
@RequestMapping("/alumnos/borrar")
public List<Alumno>borrarAlumno(
		@RequestParam(value="legajo",defaultValue="null",required=true)int leg){
	try{
		if(listaAlu.size()==0)
			cargarAlumnos();
		for(Alumno a:listaAlu){
			if(a.getLegajo()==leg){
				listaAlu.remove(a);
			}
		}
		return listaAlu;
	}catch(Exception e){
		return listaAlu;
	}
}
@RequestMapping("/alumnos/editar")
public List<Alumno>editarAlumno(
		
		@RequestParam(value="legajo",defaultValue="null",required=true)int leg,
		@RequestParam(value="apellido",defaultValue="null",required=true)String apellido,
		@RequestParam(value="nombre",defaultValue="null",required=true)String nombre,
		@RequestParam(value="carrera",defaultValue="null",required=true)String carrera,
		@RequestParam(value="cantidad",defaultValue="null",required=true)int cantMaterias
		){
	
	if(listaAlu.size()==0)
		cargarAlumnos();
	
		for(Alumno a:listaAlu){
			if(a.getLegajo()==leg){
				a.setApellido(apellido);
				a.setNombre(nombre);
				a.setCarrera(carrera);
				a.setCantMaterias(cantMaterias);
			}
		}
		return listaAlu;
}
}
