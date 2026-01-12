package com.vti.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.vti.dto.ApiError;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

//	Validate dữ liệu
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
//		Map<String, String> errors = new HashMap<>();
//		ex.getBindingResult().getFieldErrors().forEach(err -> {
//			errors.put(err.getField(), err.getDefaultMessage());
//		});

		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(err -> err.getField() + ": " + err.getDefaultMessage()).collect(Collectors.toList());

		Map<String, Object> body = new HashMap<>();
		body.put("status", HttpStatus.BAD_REQUEST.value());
		body.put("error", "Bad Request");
		body.put("errors", errors);
		body.put("path", request.getRequestURI());

		ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Bad Request",
				ex.getMessage(), request.getRequestURI(), errors);

		return ResponseEntity.badRequest().body(apiError);

	}

//	Validate dữ liệu pathVariable
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex, HttpServletRequest request) {
//		Map<String, String> errors = new HashMap<>();
//		ex.getBindingResult().getFieldErrors().forEach(err -> {
//			errors.put(err.getField(), err.getDefaultMessage());
//		});

//		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
//				.map(err -> err.getField() + ": " + err.getDefaultMessage()).collect(Collectors.toList());
//
//		Map<String, Object> body = new HashMap<>();
//		body.put("status", HttpStatus.BAD_REQUEST.value());
//		body.put("error", "Bad Request");
//		body.put("errors", errors);
//		body.put("path", request.getRequestURI());
//
//		ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Bad Request",
//				ex.getMessage(), request.getRequestURI(), errors);

		Map<String, Object> body = new HashMap<>();
		body.put("status", HttpStatus.BAD_REQUEST.value());
		body.put("error", "Bad Request");
		body.put("message", ex.getMessage());
		body.put("path", request.getRequestURI());

		return ResponseEntity.badRequest().body(body);

	}

//	Validate dữ liệu pathVariable
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex,
			HttpServletRequest request) {
//		Map<String, String> errors = new HashMap<>();

		Map<String, Object> body = new HashMap<>();
		body.put("status", HttpStatus.BAD_REQUEST.value());
		body.put("error", "Bad Request");
		body.put("message", ex.getMessage());
		body.put("path", request.getRequestURI());

		return ResponseEntity.badRequest().body(body);

	}

//	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleEntityNotFound(EntityNotFoundException ex, HttpServletRequest request) {
		Map<String, Object> body = new HashMap<>();
		body.put("status", HttpStatus.NOT_FOUND.value());
//		body.put("error", "Account not found ");
		body.put("message", ex.getMessage());
		body.put("path", request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
//		Map<String, Object> body = new HashMap<>();
//		body.put("status", HttpStatus.NOT_FOUND.value());
//		body.put("error", "Account not found ");
//		body.put("message", ex.getMessage());
//		body.put("path", request.getRequestURI());

		ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Not Found",
				ex.getMessage(), request.getRequestURI(), null);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> handleBadRequestException(BadRequestException ex, HttpServletRequest request) {

		ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Bad Request",
				ex.getMessage(), request.getRequestURI(), null);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
}
