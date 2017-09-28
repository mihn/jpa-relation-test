package mihn.jpatest.jparelationtest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class Three {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    private One one;

    @ManyToOne
    private Two two;

    @Fetch(FetchMode.JOIN)
    @JoinColumns({
            @JoinColumn(name = "one_id", referencedColumnName = "oneId", insertable = false, updatable = false),
            @JoinColumn(name = "two_id", referencedColumnName = "twoId", insertable = false, updatable = false)
    })
    private OneTwo oneTwo;

    public Three(One one, Two two) {
        this.one = one;
        this.two = two;
    }
}
