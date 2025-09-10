package com.anpa.crud.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@Table(name = "usuario")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "last_name")
    @JsonProperty("lastName")
    private String lastName;

    @Column(name = "lugar_residencia")
    @JsonProperty("lugarResidencia")
    private String lugarResidencia;

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', lastName='" + lastName + "', lugarResidencia='" + lugarResidencia + "'}";
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLugarResidencia() {
        return lugarResidencia;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }
}
