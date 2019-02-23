package com.achilles.models.taxbracket;

import com.achilles.models.TaxBracket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class TaxBracketCeilingTest {
    //#region Fields
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { -1, true },
                { 10000, false },
                { 100000, false }
        });
    }

    private double input;
    private boolean expected;
    //#endregion

    //#region Constructors
    public TaxBracketCeilingTest(double input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }
    //#endregion

    //#region Public Methods
    @Test
    public void testTaxBracketCeilings() {
        double fakeMin = 0;
        double fakeRate = 0;
        TaxBracket bracket = new TaxBracket(fakeMin, input, fakeRate);

        assertThat(bracket.isCeiling()).isEqualTo(expected);
    }
    //#endregion
}
