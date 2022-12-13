package br.com.gft.dto.exeptionDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ApiErrorDTO {
    private String message;
    private List<String> errors;
    private HttpStatus status;

    public ApiErrorDTO(String message, String errors, HttpStatus status) {
        this.message = message;
        this.errors = Arrays.asList(errors);
        this.status = status;
    }

}
