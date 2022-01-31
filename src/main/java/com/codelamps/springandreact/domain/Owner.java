package com.codelamps.springandreact.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@JsonIgnoreProperties({
        "hibernateLazyInitializer", "handler"
})
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ownerId;
    private String firstName, lastName;

    public Owner(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    @JsonIgnore
    private List<Car> carList;

    @ManyToMany
    @JoinTable(name = "car_owner", joinColumns = {@JoinColumn(name = "ownerid")}, inverseJoinColumns = {@JoinColumn(name = "id")})
    private Set<Car> cars = new HashSet<>(0);
}
