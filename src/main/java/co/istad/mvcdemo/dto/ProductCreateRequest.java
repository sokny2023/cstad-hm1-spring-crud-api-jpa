package co.istad.mvcdemo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductCreateRequest(
        @NotBlank
        String name,

        @Positive
        @NotNull
        Double price,

        @NotNull
        @Max(100)
        Integer qty
) {
}
