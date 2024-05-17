package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyDto {
    private Long idCompany;

    private String nombre;

    private String banner;

    private String admitenMascotas;
}
