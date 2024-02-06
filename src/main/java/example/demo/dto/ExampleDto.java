package example.demo.dto;

import com.google.gson.annotations.SerializedName;
import example.demo.domain.types.Gender;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

public final class ExampleDto {
    @Builder
    public record ExampleCreationRequestDto(
            @NotBlank
            // if clients send with snake_case or another name (gson)
            @SerializedName(value = "full_name", alternate = {"fullName", "name"})
            String fullName,

            @NotNull
            Gender gender,

            @Min(0)
            @Max(255)
            @NotNull
            Integer age
    ) {}

    @Builder
    public record ExampleCreationResponseDto(
            @SerializedName("result")
            String mappedResultString,
            // 모든 필드는 직렬화 시 값이 null이면 생략됨. (FE typescript 사용 시 undefined 통일 대응)
            Boolean success
    ) {}
}
