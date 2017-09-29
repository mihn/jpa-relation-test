package mihn.jpatest.jparelationtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaRelationTestApplicationTests {


    @Autowired
    private OneTwoRepository oneTwoRepository;
    @Autowired
    private OneRepository oneRepository;
    @Autowired
    private TwoRepository twoRepository;
    @Autowired
    private ThreeRepository threeRepository;

    @Test
    public void should_load_three_with_relation_to_OneTwo() {
        One one = oneRepository.save(new One());
        Two two = twoRepository.save(new Two());
        oneTwoRepository.save(new OneTwo(one.getId(), two.getId()));
        Three three = threeRepository.save(new Three(one, two));


        Three newThree = threeRepository.findOne(three.getId());

        assertThat(newThree, notNullValue());
        assertThat(newThree.getOneTwo(), notNullValue());
    }

    @Test
//    @Transactional
    public void should_load_three_without_relation_to_OneTwo() {
        One one = oneRepository.save(new One());
        Two two = twoRepository.save(new Two());
        Three three = threeRepository.save(new Three(one, two));


        Three newThree = threeRepository.findOne(three.getId());

        assertThat(newThree, notNullValue());
        assertThat(newThree.getOne(), notNullValue());
        assertThat(newThree.getTwo(), notNullValue());
        assertThat(newThree.getOneTwo(), nullValue());
    }

}
