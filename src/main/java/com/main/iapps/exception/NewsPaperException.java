package com.main.iapps.exception;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.main.iapps.payload.NewsPaperNotFoundResponse;

/**
 * This class is to handle global exception while uploading xml file and Data not Found Exception.
 *
 * @author Tatvasoft
 * @since 14-February-2023
 */

@ControllerAdvice
public class NewsPaperException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<String> handleMaxSizeException(MaxUploadSizeExceededException exception) {
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("File is too large");
	}
	
	@ExceptionHandler(FileNotFoundException.class)
	public ResponseEntity<String> handleMaxSizeException(FileNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("File Not Found Exception");
	}
	
	@ExceptionHandler(NewsPaperNotFoundException.class)
    public ResponseEntity<NewsPaperNotFoundResponse> handleException(NewsPaperNotFoundException exception){
		NewsPaperNotFoundResponse errorResponse = new NewsPaperNotFoundResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<NewsPaperNotFoundResponse>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<NewsPaperNotFoundResponse> handleException(Exception ex){
    	NewsPaperNotFoundResponse errorResponse = new NewsPaperNotFoundResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<NewsPaperNotFoundResponse>(errorResponse,HttpStatus.BAD_REQUEST);
    }

}
