package mx.softixx.cis.cloud.participant.persistence.model;

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
 * Persistent class for entity stored in table "doctor"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "doctor", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.doctor_id_seq", allocationSize = 1)
public class Doctor extends BaseEntity {

	@Column(name = "professional_license")
	@Convert(converter = AttributeEncryptor.class)
	private String professionalLicense;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "doctor", targetEntity = DoctorSpeciality.class)
	private List<DoctorSpeciality> doctorSpecialities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", targetEntity = NurseDoctor.class)
	private List<NurseDoctor> nurseDoctors;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", targetEntity = AssistantDoctor.class)
	private List<AssistantDoctor> assistantDoctors;

	public Doctor() {
	}

	public Doctor(String professionalLicense) {
		this.professionalLicense = professionalLicense;
		this.active = true;
	}

	/* Getters and Setters */
	public String getProfessionalLicense() {
		return professionalLicense;
	}

	public void setProfessionalLicense(String professionalLicense) {
		this.professionalLicense = professionalLicense;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<DoctorSpeciality> getDoctorSpecialities() {
		if (doctorSpecialities == null) {
			doctorSpecialities = new ArrayList<>();
		}
		return doctorSpecialities;
	}

	public void setDoctorSpecialities(List<DoctorSpeciality> doctorSpecialities) {
		this.doctorSpecialities = doctorSpecialities;
	}

	public List<NurseDoctor> getNurseDoctors() {
		if (nurseDoctors == null) {
			nurseDoctors = new ArrayList<>();
		}
		return nurseDoctors;
	}

	public void setNurseDoctors(List<NurseDoctor> nurseDoctors) {
		this.nurseDoctors = nurseDoctors;
	}

	public List<AssistantDoctor> getAssistantDoctors() {
		if (assistantDoctors == null) {
			assistantDoctors = new ArrayList<>();
		}
		return assistantDoctors;
	}

	public void setAssistantDoctors(List<AssistantDoctor> assistantDoctors) {
		this.assistantDoctors = assistantDoctors;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(professionalLicense);
		sb.append("|");
		sb.append(active);
		sb.append("|");
		sb.append(active);
		return sb.toString();
	}

}