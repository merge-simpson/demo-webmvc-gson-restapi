package example.demo.controllers;

import example.demo.dto.ExampleDto.ExampleCreationRequestDto;
import example.demo.dto.ExampleDto.ExampleCreationResponseDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public final class DemoApi {
    @PostMapping("/example")
    @ResponseStatus(HttpStatus.CREATED)
    public ExampleCreationResponseDto postExample(@RequestBody @Valid ExampleCreationRequestDto body) {
        log.info("Mapped DTO: {}", body);

        return ExampleCreationResponseDto.builder()
                .mappedResultString(body.toString())
                .success(true)
                .build();
    }
}
