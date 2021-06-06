package com.mehenni.sellit.model.mySQLEntity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class MySQLModel implements Comparable<MySQLModel>, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Boolean protege;

	@CreatedDate
	private Date createdDate = new Date();

	@LastModifiedDate
	private Date lastModifiedDate;

	@Version
	private Integer version;

	abstract public String getLabel();

	abstract public String getName();

	public Long getId() {
		return id;
	}
	
	public final void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getId() == null)
			return false;
		if (!this.getClass().getName().equals(obj.getClass().getName()))
			return false;
		return this.getId() == ((MySQLModel) obj).getId();
	}

	@Override
	public int compareTo(MySQLModel arg0) {
		return this.getId() == arg0.getId() ? 0 : this.getId() < arg0.getId() ? -1 : 1;
	}

	@Override
	public final String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return super.toString();
	}

	public Boolean getProtege() {
		return protege;
	}

	public void setProtege(Boolean protege) {
		this.protege = protege;
	}

	public static enum TypeExtension {
		TEXTE, DATE, NOMBRE, BOOLEEN, LISTE
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}