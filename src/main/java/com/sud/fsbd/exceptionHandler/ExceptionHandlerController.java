package com.sud.fsbd.exceptionHandler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(Exception.class)
	public ProblemDetail HandleException(Exception ex) {
		ProblemDetail pb = ProblemDetail.forStatus(HttpStatusCode.valueOf(404));
		pb.setTitle("Not found");
		pb.setDetail(ex.getMessage());
		
		return pb;
	}
	
	@ExceptionHandler(RecordNotFoundException.class)
	public ProblemDetail RecordNotFoundExceptionHandler(RecordNotFoundException ex) {
		ProblemDetail pb = ProblemDetail.forStatus(HttpStatusCode.valueOf(404));
		pb.setTitle("Record not found");
		pb.setDetail(ex.getMessage());
		
		return pb;
	}
}
