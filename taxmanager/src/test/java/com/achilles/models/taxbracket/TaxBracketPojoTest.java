package com.achilles.models.taxbracket;

import com.achilles.models.TaxBracket;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxBracketPojoTest {
    //#region Private Methods
    private TaxBracket buildFakeBracket() {
        double fakeMin = 0;
        double fakeMax = 0;
        double fakeRate = 0;

        return new TaxBracket(fakeMin, fakeMax, fakeRate);
    }
    //#endregion

    @Test
    public void testMinAmountAccessors() {
        double expected = 50000000;
        TaxBracket bracket = buildFakeBracket();

        bracket.setMinAmount(expected);
        double output = bracket.getMinAmount();

        assertThat(output).isEqualTo(expected);
    }

    @Test
    public void testCapAmountAccessors() {
        double expected = 50000000;
        TaxBracket bracket = buildFakeBracket();

        bracket.setCapAmount(expected);
        double output = bracket.getCapAmount();

        assertThat(output).isEqualTo(expected);
    }

    @Test
    public void testRateAccessors() {
        double expected = 50000000;
        TaxBracket bracket = buildFakeBracket();

        bracket.setTaxRate(expected);
        double output = bracket.getTaxRate();

        assertThat(output).isEqualTo(expected);
    }
}
