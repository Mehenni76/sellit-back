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
public class Droit extends MySQLModel {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "droit";

	private String type_de_droit;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="droit")
	private List<Utilisateur> utilisateurs;

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}
}