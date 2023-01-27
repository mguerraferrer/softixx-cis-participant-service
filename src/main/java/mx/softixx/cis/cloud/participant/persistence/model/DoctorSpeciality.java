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
 * Persistent class for entity stored in table "doctor_speciality"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "doctor_speciality", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.assistant_id_seq", allocationSize = 1)
public class DoctorSpeciality extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;
	
    @Column(name = "speciality_id")
    private Long specialityId;
	
    @Column(name = "professional_license")
    @Convert(converter = AttributeEncryptor.class)
    private String professionalLicense;

    @Column(name = "appointment_duration")
    private Integer appointmentDuration;

    @Column(name = "active")
    private boolean active;

    public DoctorSpeciality() {
    }
    
    public DoctorSpeciality(Doctor doctor, Long specialityId, String professionalLicense, Integer appointmentDuration) {
		this.doctor = doctor;
		this.specialityId = specialityId;
		this.professionalLicense = professionalLicense;
		this.appointmentDuration = appointmentDuration;
		this.active = true;
    }

    /* Getters and Setters */
	public String getProfessionalLicense() {
		return professionalLicense;
	}

	public void setProfessionalLicense(String professionalLicense) {
		this.professionalLicense = professionalLicense;
	}

	public Integer getAppointmentDuration() {
		return appointmentDuration;
	}

	public void setAppointmentDuration(Integer appointmentDuration) {
		this.appointmentDuration = appointmentDuration;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
    
    public Long getSpecialityId() {
		return specialityId;
	}

	public void setSpecialityId(Long specialityId) {
		this.specialityId = specialityId;
	}

	/* toString */
	public String toString() { 
        var sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:");
        sb.append(professionalLicense);
        sb.append("|");
        sb.append(appointmentDuration);
        sb.append("|");
        sb.append(active);
        return sb.toString();
    }
	
}