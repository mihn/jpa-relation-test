package mihn.jpatest.jparelationtest;

import org.springframework.data.jpa.repository.JpaRepository;

interface OneTwoRepository extends JpaRepository<OneTwo, OneTwo.OneTwoPK> {
}
