package com.mehenni.sellit.model.mySQLEntity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQueries({
	@NamedQuery(name="Utilisateur.findByProfil", query="SELECT u FROM Utilisateur AS u WHERE u.profile=:profil"),
	@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")})
@Entity
@Getter @Setter @NoArgsConstructor 
public class Utilisateur extends MySQLModel {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "utilisateur";		

	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE) // 2021-05-25 <-- en bdd
	private Date dateNaissance; 
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Sexe sexe;
	
	@Column(unique = true)
	private String mail;
	private String telephone;
	private String rue;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Ville ville;

	private String complement;
	@Column(unique = true)
	private String profile;
	private String password;
	@Temporal(TemporalType.DATE)
	private Date dateInscription;
	@Temporal(TemporalType.DATE)
	private Date dateResiliation;
		
	@OneToMany(fetch=FetchType.LAZY,mappedBy="utilisateur")
	private List<Publication> listPublication;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="utilisateur")
	private List<Annonce> listeAnnonce;
	
	@ManyToMany(mappedBy = "listUtilisateurSignalement")
	private List<Signalement> signalements;
	
	@OneToMany(mappedBy="follower")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Abonnement> Listefollower;
	
	@OneToMany(mappedBy="following")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Abonnement> Listefollowing; 
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Droit droit;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private MotifResiliation MotifResiliation;

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}
}