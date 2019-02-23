package com.achilles.models.taxrelief;

import com.achilles.enums.CivilStatus;
import com.achilles.models.TaxRelief;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TaxReliefPojoTest {
    @Test
    public void testCivilStatus() {
        TaxRelief subject = new TaxRelief();
        CivilStatus input = CivilStatus.MARRIED;

        subject.setCivilStatus(input);
        CivilStatus output = subject.getCivilStatus();

        assertThat(output).isEqualTo(output);
    }

    @Test
    public void testDependentCount() {
        TaxRelief subject = new TaxRelief();
        int input = 5;

        subject.setNumberOfDependents(input);
        int output = subject.getNumberOfDependents();

        assertThat(output).isEqualTo(output);
    }

    @Test
    public void testReliefValue() {
        TaxRelief subject = new TaxRelief();
        double input = 5;

        subject.setReliefValue(input);
        double output = subject.getReliefValue();

        assertThat(output).isEqualTo(output);
    }
}
