INSERT INTO common.person(
	id, name, paternal_surname, maternal_surname, dob, photo, sex_id, rfc, curp, country_id, race_id, academic_status_id, marital_status_id, occupation, religion, identity, active)
	VALUES (1, 'OWTO2f1Jei04usjKOmSwgQ==', 'qegpOlTtlqlKr1lYjjLW8A==', 'wXCfMztYSw0p8O6xYgxuIw==', '1980-01-07', null, 2, '', '', null, null, null, null, null, null, 'kYAdQdU+mW7UyGynUzu4jgtUekefo0wzlLG+dM6g0X0=', true);
	
INSERT INTO common.doctor (id, professional_license, active) VALUES
	 (1, 'd29s2gB5uC7DVcAu6j+bfQ==', true);

INSERT INTO common.doctor_speciality (id, doctor_id, speciality_id, professional_license, appointment_duration, active) VALUES
	 (1, 1, 2, 'k2170LiF7+jCQ+rbhy199A==', 30, true);
	  