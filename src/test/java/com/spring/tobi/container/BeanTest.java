package com.spring.tobi.container;

import com.spring.tobi.user.dao.v4.DaoFactoryV4;
import com.spring.tobi.user.dao.v4.MariaConnectionV4;
import com.spring.tobi.user.dao.v4.UserDaoV4;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class BeanTest {

    @Test
    void equalsTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactoryV4.class);
        UserDaoV4 bean1 = applicationContext.getBean("userDaoMaria", UserDaoV4.class);
        UserDaoV4 bean2 = applicationContext.getBean("userDaoMaria", UserDaoV4.class);

        UserDaoV4 dao1 = new DaoFactoryV4().userDaoMaria();
        UserDaoV4 dao2 = new DaoFactoryV4().userDaoMaria();

        assertThat(bean1 == bean2).isTrue();
        assertThat(dao1 == dao2).isFalse();
    }
}
