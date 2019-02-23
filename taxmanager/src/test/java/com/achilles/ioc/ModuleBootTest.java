package com.achilles.ioc;

import com.google.inject.Guice;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;


public class ModuleBootTest {
    @Test
    public void testIocMapping() {
        assertThatCode(() -> {
            Guice.createInjector(new TaxManagerModule());
        }).doesNotThrowAnyException();
    }
}
