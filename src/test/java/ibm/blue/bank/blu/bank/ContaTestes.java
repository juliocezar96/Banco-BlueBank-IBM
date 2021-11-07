package ibm.blue.bank.blu.bank;

import ibm.blue.bank.blu.bank.model.Conta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTestes {
    @Test
    void deveSerCriadaComSaldoTest(){
        Conta c = new Conta();

        c.setSaldo(100.0);

        Assertions.assertEquals(c.getSaldo()<= 0, false);
    }
}
