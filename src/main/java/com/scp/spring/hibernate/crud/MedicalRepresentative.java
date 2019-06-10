package com.scp.spring.hibernate.crud;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "boot_medical_repr_info")
public class MedicalRepresentative {
		
	@Id
	private int medicalReprId;
	private String medicalReprName;
	private String medicalReprAddress;
	private int medialReprAge;

	@OneToMany(mappedBy = "listOfRepresentatives",cascade = CascadeType.ALL)
	private List<Drugs> listOfDrugs;
	
	
	

	
	public MedicalRepresentative() {
		// TODO Auto-generated constructor stub
	}

}
