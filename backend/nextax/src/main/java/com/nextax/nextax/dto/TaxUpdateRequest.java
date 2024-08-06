package com.nextax.nextax.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxUpdateRequest {

    private String duration;
    private int price;
}
