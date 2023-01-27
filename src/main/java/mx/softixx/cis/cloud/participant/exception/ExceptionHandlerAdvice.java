package mx.softixx.cis.cloud.participant.exception;

import java.util.Map;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import mx.softixx.cis.common.participant.exception.DoctorNotFoundException;
import mx.softixx.cis.common.participant.exception.PersonNotFoundException;
import mx.softixx.cis.common.validation.util.ProblemDetailUtils;

@Order(Ordered.LOWEST_PRECEDENCE)
@RestControllerAdvice
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler(DoctorNotFoundException.class)
	public ProblemDetail handlerUserNotFoundException(DoctorNotFoundException e) {
		Map<String, Object> properties = Map.of("id", e.getId());
		return ProblemDetailUtils.notFound(e.getMessage(), properties);
	}
	
	@ExceptionHandler(PersonNotFoundException.class)
	public ProblemDetail handlerPersonNotFoundException(PersonNotFoundException e) {
		Map<String, Object> properties = Map.of("id", e.getId());
		return ProblemDetailUtils.notFound(e.getMessage(), properties);
	}
	
}