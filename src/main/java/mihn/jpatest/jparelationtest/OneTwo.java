package mihn.jpatest.jparelationtest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@NoArgsConstructor(access = PRIVATE)
class OneTwo {

    @EmbeddedId
    private OneTwoPK id;

    OneTwo(Long oneId, Long twoId) {
        this.id = new OneTwoPK(oneId, twoId);
    }

    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor(access = PRIVATE)
    static class OneTwoPK implements Serializable {

        private Long oneId;
        private Long twoId;
    }
}
