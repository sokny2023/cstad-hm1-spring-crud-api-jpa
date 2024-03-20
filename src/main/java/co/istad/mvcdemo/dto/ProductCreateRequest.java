package co.istad.mvcdemo.dto;

public record ProductCreateRequest(
        String name,
        Double price,
        Integer qty
) {
}
