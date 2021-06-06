package com.mehenni.sellit.model.mySQLEntity;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 
public class Publication extends MySQLModel {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "publication";
;
	private String titre;
	private String texte;
	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
	private Date date_de_debut;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="publicationSupport")
	private List<Support> supports;
		
	@ManyToMany(mappedBy = "listPublicationTheme")
	private List<Theme> themes;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Utilisateur utilisateur;	
	
	@OneToMany
	@JoinColumn(referencedColumnName = "id")
	private List<Signalement> signalements;
	
	public Publication(String titre, String texte) {
		super();
		this.titre = titre;
		this.texte = texte;
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