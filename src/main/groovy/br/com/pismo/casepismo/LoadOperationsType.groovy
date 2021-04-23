package br.com.pismo.casepismo

import br.com.pismo.casepismo.models.OperationsType
import br.com.pismo.casepismo.repositories.OperationsTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class LoadOperationsType implements ApplicationRunner {

    @Autowired
    OperationsTypeRepository operationsTypeRepository

    @Override
    void run(ApplicationArguments args) throws Exception {
        operationsTypeRepository.save(new OperationsType(id: 1, description: "COMPRA A VISTA"))
        operationsTypeRepository.save(new OperationsType(id: 2, description: "COMPRA PARCELADA"))
        operationsTypeRepository.save(new OperationsType(id: 3, description: "SAQUE"))
        operationsTypeRepository.save(new OperationsType(id: 4, description: "PAGAMENTO"))
    }
}
