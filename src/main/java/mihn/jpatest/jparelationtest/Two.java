package mihn.jpatest.jparelationtest;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
class Two {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Getter
    private Long id;
}
