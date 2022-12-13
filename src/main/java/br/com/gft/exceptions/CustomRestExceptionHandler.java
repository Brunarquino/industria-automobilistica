package br.com.gft.exceptions;

import br.com.gft.dto.exeptionDTO.ApiErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomRestExceptionHandler {
    @ExceptionHandler({IndustriaAutomobilisticaException.class})
    public ResponseEntity<ApiErrorDTO> handleLojaException(IndustriaAutomobilisticaException e, WebRequest request){
        String error = "Erro no sistema";
        ApiErrorDTO apiErroDTO = new ApiErrorDTO(e.getMessage(), error, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<ApiErrorDTO>(apiErroDTO, new HttpHeaders(), apiErroDTO.getStatus());
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ApiErrorDTO> handleEntityNotFoundException(EntityNotFoundException e, WebRequest request){
        String error = "Recurso não encontrada";
        ApiErrorDTO apiErroDTO = new ApiErrorDTO(e.getMessage(), error, HttpStatus.NOT_FOUND);
        return new ResponseEntity<ApiErrorDTO>(apiErroDTO, new HttpHeaders(), apiErroDTO.getStatus());
    }

    @ExceptionHandler({ColumnNotNullException.class})
    public ResponseEntity<ApiErrorDTO> handleEntityNotFoundException(ColumnNotNullException e, WebRequest request){
        String error = "Coluna não pode ser vazia";
        ApiErrorDTO apiErroDTO = new ApiErrorDTO(e.getMessage(), error, HttpStatus.NOT_FOUND);
        return new ResponseEntity<ApiErrorDTO>(apiErroDTO, new HttpHeaders(), apiErroDTO.getStatus());
    }
}
