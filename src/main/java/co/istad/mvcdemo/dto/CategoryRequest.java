package co.istad.mvcdemo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(
        @NotBlank
        @Size(max = 40)
        String name,

        @NotBlank
        String description
) {
}
