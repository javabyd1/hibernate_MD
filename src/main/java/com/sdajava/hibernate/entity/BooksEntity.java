package com.sdajava.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "books", schema = "ksiegarnia")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BooksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ksiazki", nullable = false)
    private int id;

    @Column (name = "tytul")
    private String title;

    @Column (name = "autor")
    private String author;

    @Column (name = "ISBN")
    private String isbn;

    @Column (name = "rok_wydania")
    private java.sql.Date published;

    @Column (name = "kategoria")
    private String category;

    @Column (name = "liczba_stron")
    private Integer pageCount;

    @Column (name = "cena")
    private BigDecimal price;

    @Column (name = "dostepnosc")
    private Integer onStock;


}
