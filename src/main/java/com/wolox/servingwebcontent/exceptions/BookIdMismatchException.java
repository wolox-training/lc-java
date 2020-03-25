package com.wolox.servingwebcontent.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "id mismatch exception")
public class BookIdMismatchException extends RuntimeException {}
