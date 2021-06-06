package com.mehenni.sellit.model.mySQLEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 
public class Signalement extends MySQLModel {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "signalement";

	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
	private Date date_de_signalement;
	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
	private Date date_de_traitement;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private MotifSignalement motifSignalement;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "utilisateur_signalement",
	joinColumns = {@JoinColumn(name = "signalement_id")},
	inverseJoinColumns = {@JoinColumn(name = "utilisateur_id")})
	private List<Utilisateur> listUtilisateurSignalement;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Publication publication;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Annonce annonce;
	
	public void addUtilisateur(Utilisateur u) {
		if (listUtilisateurSignalement == null) {
			listUtilisateurSignalement = new ArrayList<Utilisateur>();
		}
		this.listUtilisateurSignalement.add(u);
	}

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}
}