package com.crud.crudproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
<<<<<<< HEAD


@Entity(name="roles")
public class Role {
=======
=======
>>>>>>> refs/remotes/origin/main
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

<<<<<<< HEAD
>>>>>>> 3dbdd575f46192be287b31a54040bce9212b8dd6
=======
>>>>>>> refs/remotes/origin/main
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

<<<<<<< HEAD
<<<<<<< HEAD
    @Column(length = 60)
    private String name;
    
    
=======
>>>>>>> 3dbdd575f46192be287b31a54040bce9212b8dd6
=======
>>>>>>> refs/remotes/origin/main
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
<<<<<<< HEAD
	
=======
	@Column(length = 60)
    private String name;
>>>>>>> 3dbdd575f46192be287b31a54040bce9212b8dd6
=======
	@Column(length = 60)
    private String name;
>>>>>>> refs/remotes/origin/main
}
