package com.crud.crudproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD


@Entity(name="roles")
public class Role {
=======
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

>>>>>>> 3dbdd575f46192be287b31a54040bce9212b8dd6
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

<<<<<<< HEAD
    @Column(length = 60)
    private String name;
    
    
=======
>>>>>>> 3dbdd575f46192be287b31a54040bce9212b8dd6
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

<<<<<<< HEAD
	
=======
	@Column(length = 60)
    private String name;
>>>>>>> 3dbdd575f46192be287b31a54040bce9212b8dd6
}
