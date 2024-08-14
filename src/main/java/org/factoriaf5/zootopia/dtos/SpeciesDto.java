package org.factoriaf5.zootopia.dtos;

import java.time.LocalDate;
import lombok.Data;

@Data
public class SpeciesDto {
    private String name;
    private String type;
    private String family;
    private String gender;
    private LocalDate dateOfEntry;
    private String imageUrl;
}
