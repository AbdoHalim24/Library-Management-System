package com.AbdoHalim.LibraryManagementSystem.DTO;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BookDTO {
    private String title;
    private String author;
    private LocalDate publicationYear;

}
