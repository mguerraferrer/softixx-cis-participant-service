package mx.softixx.cis.cloud.participant.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.encryptor.converter.AttributeEncryptor;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "person_address"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "person_address", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.person_address_id_seq", allocationSize = 1)
public class PersonAddress extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
	
    @Column(name = "colony_mx_id")
    private Long colonyMxId;

    @Column(name = "street")
    @Convert(converter = AttributeEncryptor.class)
    private String street;

    @Column(name = "btw_street")
    @Convert(converter = AttributeEncryptor.class)
    private String btwStreet;

    @Column(name = "outside_number")
    @Convert(converter = AttributeEncryptor.class)
    private String outsideNumber;

    @Column(name = "inside_number")
    @Convert(converter = AttributeEncryptor.class)
    private String insideNumber;

    @Column(name = "reference")
    @Convert(converter = AttributeEncryptor.class)
    private String reference;

    @Column(name = "active")
    private boolean active;

    /* Getters and Setters */
    public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Long getColonyMxId() {
		return colonyMxId;
	}

	public void setColonyMxId(Long colonyMxId) {
		this.colonyMxId = colonyMxId;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBtwStreet() {
		return btwStreet;
	}

	public void setBtwStreet(String btwStreet) {
		this.btwStreet = btwStreet;
	}

	public String getOutsideNumber() {
		return outsideNumber;
	}

	public void setOutsideNumber(String outsideNumber) {
		this.outsideNumber = outsideNumber;
	}

	public String getInsideNumber() {
		return insideNumber;
	}

	public void setInsideNumber(String insideNumber) {
		this.insideNumber = insideNumber;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

    /* toString */
	public String toString() { 
        var sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(street);
        sb.append("|");
        sb.append(btwStreet);
        sb.append("|");
        sb.append(outsideNumber);
        sb.append("|");
        sb.append(insideNumber);
        sb.append("|");
        sb.append(reference);
        sb.append("|");
        sb.append(active);
        return sb.toString();
    }
	
}