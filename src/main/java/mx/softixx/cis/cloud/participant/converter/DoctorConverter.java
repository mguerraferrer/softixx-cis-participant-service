package mx.softixx.cis.cloud.participant.converter;

import java.util.List;

import lombok.val;
import mx.softixx.cis.cloud.participant.persistence.model.Doctor;
import mx.softixx.cis.cloud.participant.persistence.model.DoctorSpeciality;
import mx.softixx.cis.cloud.participant.persistence.model.Person;
import mx.softixx.cis.common.participant.payload.DoctorResponse;
import mx.softixx.cis.common.participant.payload.DoctorSpecialityResponse;

public final class DoctorConverter {
	
	private DoctorConverter() {		
	}
	
	public static final DoctorResponse map(Doctor doctor) {
		if (doctor == null) {
			return null;
		}
		
		return populateDoctor(doctor);
	}
	
	public static final DoctorResponse map(Doctor doctor, Person person) {
		if (doctor == null || person == null) {
			return null;
		}
		
		val doctorResponse = populateDoctor(doctor);
		doctorResponse.setPerson(PersonConverter.map(person));
		return doctorResponse;
	}

	private static DoctorResponse populateDoctor(Doctor doctor) {
		return DoctorResponse
				.builder()
				.id(doctor.getId())
				.professionalLicense(doctor.getProfessionalLicense())
				.active(doctor.isActive())
				.specialities(map(doctor.getDoctorSpecialities()))
				.build();
	}
	
	private static final List<DoctorSpecialityResponse> map(List<DoctorSpeciality> specialities) {
		return specialities.stream().map(DoctorSpecialityConverter::map).toList();
	}

}