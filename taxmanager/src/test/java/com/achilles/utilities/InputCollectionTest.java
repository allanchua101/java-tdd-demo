package com.achilles.utilities;

import com.achilles.contracts.ConsoleScannerContract;
import com.achilles.enums.CivilStatus;
import com.achilles.models.TaxCalculationRequest;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class InputCollectionTest {
    //#region Fields
    private int consoleScannerFakeCount = 0;
    //#endregion

    //#region Private Methods
    private void iterateSpyHitCount() {
        consoleScannerFakeCount += 1;
    }
    //#endregion

    //#region Public Methods
    @After
    public void resetSpy() {
        consoleScannerFakeCount = 0;
    }

    @Test
    public void testSingleFlows() {
        ConsoleScannerContract mockedScanner = Mockito.mock(ConsoleScannerContract.class);
        String simulatedMonthlySalary = "25000000";
        String simulatedCivilStatusKey = "1";

        Mockito.when(mockedScanner.execute())
                .thenAnswer(new Answer<String>(){
                    public String answer(InvocationOnMock invocation) {
                        iterateSpyHitCount();

                        switch(consoleScannerFakeCount) {
                            case 1:
                                return simulatedMonthlySalary;
                            case 2:
                                return simulatedCivilStatusKey;
                        }

                        return "";
                    }
                });

        InputCollector collector = new InputCollector(mockedScanner);
        TaxCalculationRequest request = collector.execute();

        assertThat(request.getMonthlyIncome()).isEqualTo(Float.parseFloat(simulatedMonthlySalary));
        assertThat(request.getCivilStatus()).isEqualTo(CivilStatus.SINGLE);
    }

    @Test
    public void testMarriedFlows() {
        ConsoleScannerContract mockedScanner = Mockito.mock(ConsoleScannerContract.class);
        String simulatedMonthlySalary = "25000000";
        String simulatedCivilStatusKey = "2";
        String simulatedDependentCount = "2";

        Mockito.when(mockedScanner.execute())
                .thenAnswer(new Answer<String>(){
                    public String answer(InvocationOnMock invocation) {
                        iterateSpyHitCount();

                        switch(consoleScannerFakeCount) {
                            case 1:
                                return simulatedMonthlySalary;
                            case 2:
                                return simulatedCivilStatusKey;
                            case 3:
                                return simulatedDependentCount;
                        }

                        return "";
                    }
                });

        InputCollector collector = new InputCollector(mockedScanner);
        TaxCalculationRequest request = collector.execute();

        assertThat(request.getMonthlyIncome()).isEqualTo(Float.parseFloat(simulatedMonthlySalary));
        assertThat(request.getCivilStatus()).isEqualTo(CivilStatus.MARRIED);
        assertThat(request.getDependentCount()).isEqualTo(Integer.parseInt(simulatedDependentCount));
    }

    @Test
    public void testInvalidCivilStatusFlow() {
        ConsoleScannerContract mockedScanner = Mockito.mock(ConsoleScannerContract.class);
        String simulatedMonthlySalary = "25000000";
        String simulatedFailingCivilStatusKey = "4";
        String simulatedCivilStatusKey = "2";
        String simulatedDependentCount = "2";

        Mockito.when(mockedScanner.execute())
                .thenAnswer(new Answer<String>(){
                    public String answer(InvocationOnMock invocation) throws Exception {
                        iterateSpyHitCount();

                        switch(consoleScannerFakeCount) {
                            case 1:
                                return simulatedMonthlySalary;
                            case 2:
                                return simulatedFailingCivilStatusKey;
                            case 3:
                                return simulatedCivilStatusKey;
                            case 4:
                                return simulatedDependentCount;
                            default:
                                throw new Exception("Infinite Loop");
                        }
                    }
                });

        InputCollector collector = new InputCollector(mockedScanner);
        TaxCalculationRequest request = collector.execute();

        assertThat(request.getMonthlyIncome()).isEqualTo(Float.parseFloat(simulatedMonthlySalary));
        assertThat(request.getCivilStatus()).isEqualTo(CivilStatus.MARRIED);
        assertThat(request.getDependentCount()).isEqualTo(Integer.parseInt(simulatedDependentCount));
    }

    @Test
    public void testInvalidMonthlySalaryFlow() {
        ConsoleScannerContract mockedScanner = Mockito.mock(ConsoleScannerContract.class);
        String simulatedFailingMonthlySalary = "ABC";
        String simulatedMonthlySalary = "25000000";
        String simulatedCivilStatusKey = "2";
        String simulatedDependentCount = "2";

        Mockito.when(mockedScanner.execute())
                .thenAnswer(new Answer<String>(){
                    public String answer(InvocationOnMock invocation) throws Exception {
                        iterateSpyHitCount();

                        switch(consoleScannerFakeCount) {
                            case 1:
                                return simulatedFailingMonthlySalary;
                            case 2:
                                return simulatedMonthlySalary;
                            case 3:
                                return simulatedCivilStatusKey;
                            case 4:
                                return simulatedDependentCount;
                            default:
                                throw new Exception("Infinite Loop");
                        }
                    }
                });

        InputCollector collector = new InputCollector(mockedScanner);
        TaxCalculationRequest request = collector.execute();

        assertThat(request.getMonthlyIncome()).isEqualTo(Float.parseFloat(simulatedMonthlySalary));
        assertThat(request.getCivilStatus()).isEqualTo(CivilStatus.MARRIED);
        assertThat(request.getDependentCount()).isEqualTo(Integer.parseInt(simulatedDependentCount));
    }
    //#endregion
}
