package com.alaeldin.erpschoolSystem.country.town.entity;

import com.alaeldin.erpschoolSystem.country.country.entity.Country;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class City {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name",nullable = false,length = 300)
    private String name;
    @Column(name = "name2",length = 300)
    private String name2;
    @Column(length = 3)
    @Nullable
    private String hieCode;
    @Column(length = 2000)
    @Nullable
    private String hieDesc;

    @Column(length = 3)
    @Nullable
   private String dohCode;
    //@JsonBackReference
    //@JsonIdentityReference

    @ManyToOne()
    @JoinColumn(name = "country_id",referencedColumnName="id", insertable=false, updatable=false)
   private Country country;
    @Column(nullable = false)
    private long country_id;

}
