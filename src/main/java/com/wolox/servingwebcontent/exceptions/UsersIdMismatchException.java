package com.wolox.servingwebcontent.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Id mismatch exception")

public class UsersIdMismatchException extends RuntimeException { }
