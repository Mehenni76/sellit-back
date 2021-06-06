package com.mehenni.sellit.model.mySQLEntity;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 
public class Annonce extends MySQLModel {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "annonce";

	private String titre;
	private String description;
	private double prix;
	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
	private Date date_de_parution;
	
	@OneToMany
	@JoinColumn(referencedColumnName = "id")
	private List<Support> supports;
		
	@ManyToMany(mappedBy = "listAnnonceTheme")
	private List<Theme> themes;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Utilisateur utilisateur;	
	
	@OneToMany
	@JoinColumn(referencedColumnName = "id")
	private List<Signalement> signalements;

	@Override
	public String getLabel() {
		return titre;
	}

	@Override
	public String getName() {
		return null;
	}
}