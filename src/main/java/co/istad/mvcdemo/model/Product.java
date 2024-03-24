package co.istad.mvcdemo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uuid;
    @NotBlank
    private String name;
    @NotNull
    private Double price;
    @NotNull
    private Integer qty;
    private LocalDate importedDate;
    private Boolean status;

    /*@ManyToOne
    private Category category;*/

}
