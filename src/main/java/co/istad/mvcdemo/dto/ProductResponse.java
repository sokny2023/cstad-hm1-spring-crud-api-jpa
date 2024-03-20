package co.istad.mvcdemo.dto;

public record ProductResponse(
        String uuid,
        String name,
        Double price,
        Integer qty
) {
}
