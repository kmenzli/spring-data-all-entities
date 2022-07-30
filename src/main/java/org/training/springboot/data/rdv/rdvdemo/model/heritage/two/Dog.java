package org.training.springboot.data.rdv.rdvdemo.model.heritage.two;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name  ="DOG")
public class Dog extends Animal {

    private String danger;
}
