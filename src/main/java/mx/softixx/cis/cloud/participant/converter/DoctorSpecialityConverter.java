package mx.softixx.cis.cloud.participant.converter;

import mx.softixx.cis.cloud.participant.persistence.model.DoctorSpeciality;
import mx.softixx.cis.common.participant.payload.DoctorSpecialityResponse;

public final class DoctorSpecialityConverter {

	private DoctorSpecialityConverter() {
	}
	
	public static final DoctorSpecialityResponse map(DoctorSpeciality doctorSpeciality) {
		if (doctorSpeciality == null) {
			return null;
		}
		
		return DoctorSpecialityResponse
				.builder()
				.id(doctorSpeciality.getId())
				.doctorId(doctorSpeciality.getDoctor().getId())
				.professionalLicense(doctorSpeciality.getProfessionalLicense())
				.appointmentDuration(doctorSpeciality.getAppointmentDuration())
				.active(doctorSpeciality.isActive())
				.build();
	}

}