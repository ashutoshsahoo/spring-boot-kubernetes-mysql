package com.ashu.practice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Pet implements Serializable {

    @Serial
    private static final long serialVersionUID = 4889087778273529265L;

    @Id
    private String name;

    private String owner;

    private String species;

    private char sex;

    @Temporal(TemporalType.DATE)
    private Date birth;

    @Temporal(TemporalType.DATE)
    private Date death;

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", species='" + species + '\'' +
                ", sex=" + sex +
                ", birth=" + birth +
                ", death=" + death +
                '}';
    }
}
