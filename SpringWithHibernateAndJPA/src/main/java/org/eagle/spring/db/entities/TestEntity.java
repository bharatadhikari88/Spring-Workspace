package org.eagle.spring.db.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author SINGH.BHARAT
 *
 */
@Entity
@Table(name="test_entity")
public class TestEntity {
	
	@Id
	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
