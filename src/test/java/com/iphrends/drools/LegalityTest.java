package com.iphrends.drools;

import com.iphrends.drools.models.Legality;
import com.iphrends.drools.services.BaseDroolsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LegalityTest {

    @Autowired
    @Qualifier("legalityService")
    private BaseDroolsService<Legality> service;

    @Test
    public void teset() {
        Legality legality = service.execute(new Legality("llc"));
        Assert.assertEquals("llc", legality.getLegalityType());
        Assert.assertEquals(2, legality.getRoles().size());
        Assert.assertEquals(4, legality.getActivitiesType().size());
    }
}
