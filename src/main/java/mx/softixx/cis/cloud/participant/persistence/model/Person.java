package mx.softixx.cis.cloud.participant.persistence.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.encryptor.converter.AttributeEncryptor;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "person"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "person", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.person_id_seq", allocationSize = 1)
public class Person extends BaseEntity {

	@Column(name = "race_id")
	private Long raceId;

	@Column(name = "academic_status_id")
	private Long academicStatusId;

	@Column(name = "marital_status_id")
	private Long maritalStatusId;

	@Column(name = "sex_id")
	private Long sexId;

	@Column(name = "country_id")
	private Long countryId;

	@Column(name = "name")
	@Convert(converter = AttributeEncryptor.class)
	private String name;

	@Column(name = "paternal_surname")
	@Convert(converter = AttributeEncryptor.class)
	private String paternalSurname;

	@Column(name = "maternal_surname")
	@Convert(converter = AttributeEncryptor.class)
	private String maternalSurname;

	@Column(name = "dob")
	private LocalDate dob;

	@Column(name = "photo")
	private String photo;

	@Column(name = "rfc")
	@Convert(converter = AttributeEncryptor.class)
	private String rfc;

	@Column(name = "curp")
	@Convert(converter = AttributeEncryptor.class)
	private String curp;

	@Column(name = "occupation", length = 100)
	private String occupation;

	@Column(name = "religion", length = 100)
	private String religion;

	@Column(name = "identity")
	@Convert(converter = AttributeEncryptor.class)
	private String identity;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", targetEntity = PersonAddress.class)
	private List<PersonAddress> personAddresses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", targetEntity = PersonAccess.class)
	private List<PersonAccess> personAccesses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", targetEntity = PersonContactInfo.class)
	private List<PersonContactInfo> personContactInfos;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", targetEntity = Patient.class)
	private List<Patient> patients;

	public Person() {
	}

	public Person(String name, String paternalSurname, String maternalSurname, Long sexId) {
		this.name = name;
		this.paternalSurname = paternalSurname;
		this.maternalSurname = maternalSurname;
		this.identity = identity(this.name, this.paternalSurname, this.maternalSurname);
		this.sexId = sexId;
		this.rfc = "";
		this.curp = "";
		this.active = true;
	}

	public Person(String name, String paternalSurname, String maternalSurname, Long sexId, LocalDate dob) {
		this.name = name;
		this.paternalSurname = paternalSurname;
		this.maternalSurname = maternalSurname;
		this.identity = identity(this.name, this.paternalSurname, this.maternalSurname);
		this.sexId = sexId;
		this.dob = dob;
		this.rfc = "";
		this.curp = "";
		this.active = true;
	}

	private String identity(final String name, final String paternalSurname, final String maternalSurname) {
		return String.format("%s %s %s", name.trim(), paternalSurname.trim(), maternalSurname.trim());
	}

	/* Getters and Setters */
	public Long getRaceId() {
		return raceId;
	}

	public void setRaceId(Long raceId) {
		this.raceId = raceId;
	}

	public Long getAcademicStatusId() {
		return academicStatusId;
	}

	public void setAcademicStatusId(Long academicStatusId) {
		this.academicStatusId = academicStatusId;
	}

	public Long getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(Long maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public Long getSexId() {
		return sexId;
	}

	public void setSexId(Long sexId) {
		this.sexId = sexId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPaternalSurname() {
		return paternalSurname;
	}

	public void setPaternalSurname(String paternalSurname) {
		this.paternalSurname = paternalSurname;
	}

	public String getMaternalSurname() {
		return maternalSurname;
	}

	public void setMaternalSurname(String maternalSurname) {
		this.maternalSurname = maternalSurname;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public List<PersonAddress> getPersonAddresses() {
		if (personAddresses == null) {
			personAddresses = new ArrayList<>();
		}
		return personAddresses;
	}

	public void setPersonAddresses(List<PersonAddress> personAddresses) {
		this.personAddresses = personAddresses;
	}

	public void setPersonAccesses(List<PersonAccess> personAccesses) {
		this.personAccesses = personAccesses;
	}

	public List<PersonAccess> getPersonAccesses() {
		if (personAccesses == null) {
			personAccesses = new ArrayList<>();
		}
		return personAccesses;
	}

	public List<PersonContactInfo> getPersonContactInfos() {
		if (personContactInfos == null) {
			personContactInfos = new ArrayList<>();
		}
		return personContactInfos;
	}

	public void setPersonContactInfos(List<PersonContactInfo> personContactInfos) {
		this.personContactInfos = personContactInfos;
	}

	public List<Patient> getPatients() {
		if (patients == null) {
			patients = new ArrayList<>();
		}
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(name);
		sb.append("|");
		sb.append(paternalSurname);
		sb.append("|");
		sb.append(maternalSurname);
		sb.append("|");
		sb.append(identity);
		sb.append("|");
		sb.append(dob);
		sb.append("|");
		sb.append(rfc);
		sb.append("|");
		sb.append(curp);
		sb.append("|");
		sb.append(active);
		sb.append("|");
		sb.append(occupation);
		sb.append("|");
		sb.append(religion);
		return sb.toString();
	}

}