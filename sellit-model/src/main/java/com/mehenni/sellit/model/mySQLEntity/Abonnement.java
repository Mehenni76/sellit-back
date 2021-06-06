package com.mehenni.sellit.model.mySQLEntity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 
public class Abonnement extends MySQLModel  {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "abonnement";
	
	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
	private Date date_de_debut;
	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
	private Date date_de_fin;
	
	@ManyToOne
	@JoinColumn(name="follower_id")
	private Utilisateur follower;
	
	@ManyToOne
	@JoinColumn(name="following_id")
	private Utilisateur following;

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	};
}