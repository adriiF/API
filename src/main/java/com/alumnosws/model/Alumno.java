package com.alumnosws.model;

public class Alumno {
	private int legajo;
	private String nombre;
	private String apellido;
	private String carrera;
	private int cantMaterias;
	
	
//constructor
	public Alumno(int leg,String ape,String nom,String car,int cant){
		legajo=leg;
		apellido=ape;
		nombre=nom;
		carrera=car;
		cantMaterias=cant;
	}


	public int getLegajo() {
		return legajo;
	}


	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCarrera() {
		return carrera;
	}


	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}


	public int getCantMaterias() {
		return cantMaterias;
	}


	public void setCantMaterias(int cantMaterias) {
		this.cantMaterias = cantMaterias;
	}
}
