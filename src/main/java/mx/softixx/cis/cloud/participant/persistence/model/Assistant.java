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
 * Persistent class for entity stored in table "assistant"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "assistant", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.assistant_id_seq", allocationSize = 1)
public class Assistant extends BaseEntity {

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "assistant", targetEntity = AssistantDoctor.class)
	private List<AssistantDoctor> assistantDoctors;

	/* Getters and Setters */
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		sb.append(active);
		return sb.toString();
	}

}