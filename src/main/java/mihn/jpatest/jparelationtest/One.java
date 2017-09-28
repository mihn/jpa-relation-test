package mihn.jpatest.jparelationtest;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
class One {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
}
