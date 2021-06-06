package com.mehenni.sellit.model.mySQLEntity;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 
public class MotifSignalement extends MySQLModel {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "motif de signalement";

	private String libelle_motif_signalement;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="motifSignalement")
	private List<Signalement> signalements;

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}
}