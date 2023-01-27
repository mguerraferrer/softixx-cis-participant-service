package mx.softixx.cis.cloud.participant.persistence.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "nurse"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "nurse", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.nurse_id_seq", allocationSize = 1)
public class Nurse extends BaseEntity {

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nurse", targetEntity = NurseDoctor.class)
	private List<NurseDoctor> nurseDoctors;

	/* Getters and Setters */
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(active);
		return sb.toString();
	}

}