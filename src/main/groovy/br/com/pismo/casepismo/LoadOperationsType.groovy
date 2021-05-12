package br.com.pismo.casepismo

import br.com.pismo.casepismo.models.OperationsType
import br.com.pismo.casepismo.repositories.OperationsTypeRepository
import br.com.pismo.casepismo.services.AccountService
import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class LoadOperationsType implements ApplicationRunner {

    @Autowired
    OperationsTypeRepository operationsTypeRepository

    @Autowired
    AccountService accountService
    @Value("#{environment.aws_accessKey}")
    String awsKey

    @Value("#{environment.aws_pass}")
    String awsPass

    @Value("\${sqs.url}")
    String sqsUrl


    @Override
    void run(ApplicationArguments args) throws Exception {
        operationsTypeRepository.save(new OperationsType(id: 1, description: "COMPRA A VISTA"))
        operationsTypeRepository.save(new OperationsType(id: 2, description: "COMPRA PARCELADA"))
        operationsTypeRepository.save(new OperationsType(id: 3, description: "SAQUE"))
        operationsTypeRepository.save(new OperationsType(id: 4, description: "PAGAMENTO"))

        AWSCredentialsProvider provider = new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsKey, awsPass))
        AmazonSQS amazonSQS = AmazonSQSClientBuilder.standard().withRegion("us-east-2").withCredentials(provider).build()
//        while (true) {
//            amazonSQS.receiveMessage(sqsUrl).getMessages().each {
//                println """************** ${it.Body}"""
//                final String messageHandle = it.getReceiptHandle()
//                amazonSQS.deleteMessage(sqsUrl, messageHandle)
//            }
//        }
    }
}
