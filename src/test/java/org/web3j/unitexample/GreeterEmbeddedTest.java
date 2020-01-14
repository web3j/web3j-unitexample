package org.web3j.unitexample;

import org.junit.jupiter.api.Test;
import org.web3j.EVMTest;
import org.web3j.greeter.Greeter;
import org.web3j.protocol.Web3j;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

@EVMTest()
public class GreeterEmbeddedTest {
    @Test
    public void helloWorldTest(Web3j web3j,
                               TransactionManager transactionManager,
                               ContractGasProvider gasProvider) throws Exception {
        String expectedValue = "Hello Blockchain World!";

        Greeter greeter = Greeter.deploy(web3j, transactionManager, gasProvider, expectedValue).send();

        String actualValue = greeter.getGreeting().send();

        assertEquals(expectedValue, actualValue);
    }
}


