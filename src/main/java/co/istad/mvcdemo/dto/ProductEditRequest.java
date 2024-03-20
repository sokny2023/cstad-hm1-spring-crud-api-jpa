package co.istad.mvcdemo.dto;

public record ProductEditRequest(
        String name,
        Double price
) {
}
