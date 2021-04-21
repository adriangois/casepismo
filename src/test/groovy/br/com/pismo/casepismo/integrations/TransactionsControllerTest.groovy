package br.com.pismo.casepismo.integrations

import br.com.pismo.casepismo.controllers.TransactionController
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import static org.assertj.core.api.Assertions.assertThat

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TransactionsControllerTest {


    @Autowired
    TransactionController transactionController

    @Test
    void shouldGetAllTransactions() {
        def all = transactionController.findAll()
        assertThat(all.size()).isGreaterThan(4)
    }

}
