package co.istad.mvcdemo.dto;

public record ProductDto(
        String uuid,
        String name,
        Double price,
        Integer qty
) {
}
