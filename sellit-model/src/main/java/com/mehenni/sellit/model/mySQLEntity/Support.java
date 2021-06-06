package com.mehenni.sellit.model.mySQLEntity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 
public class Support extends MySQLModel {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "support";

	private String type_support;
	private String chemin;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Annonce annonce;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Publication publication;

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}
}