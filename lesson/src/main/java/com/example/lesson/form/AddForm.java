package com.example.lesson.form;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AddForm {

    @NotEmpty
    @Length(min = 1, max = 50)
    private String productName;

    @NotNull
    @Digits(integer = 10, fraction = 0)
    @Max(value=Integer.MAX_VALUE)
    @Min(value=0)
    private Integer price;
}
