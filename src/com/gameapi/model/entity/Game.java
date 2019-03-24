package com.gameapi.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
//@Table(name="Filme")
public class Game {
	@Id
	@NotNull 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Size(min=2, max=100, message="Tamanho entre 2 e 100 caracteres")
	private String name;
	@Size(max=4000, message="Tamanho entre 20 e 4000 caracteres")
	private String description;
	@NotNull
	@ManyToOne
//	@JoinColumn(name="id_genero")
//	private Genero genero;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescricao(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", description=" + description + "]";
	}



}
