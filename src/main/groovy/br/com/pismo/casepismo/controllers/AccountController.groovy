package br.com.pismo.casepismo.controllers

import br.com.pismo.casepismo.exceptions.AccountExceptions
import br.com.pismo.casepismo.models.Account

import br.com.pismo.casepismo.services.AccountService
import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.sqs.AbstractAmazonSQS
import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import com.amazonaws.services.sqs.model.SendMessageResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import javax.persistence.EntityExistsException
import javax.persistence.PersistenceException

@RestController
@RequestMapping('accounts')
class AccountController {

    @Autowired
    AccountService accountService
    @Value("#{environment.aws_accessKey}")
    String awsKey

    @Value("#{environment.aws_pass}")
    String awsPass

    @Value("\${sqs.url}")
    String sqsUrl


    @PostMapping('')
    def create(@RequestBody Account account) throws Exception {
        accountService.create(account)
    }

    @GetMapping('{id}')
    def accountById(@PathVariable long id) {
        this.notificarFila("""Acesso a conta com id= ${id}""")
        accountService.findById(id)
    }

    @ExceptionHandler([PersistenceException.class])
    def handleException(Exception ex) {
        if (ex instanceof EntityExistsException)
            new ResponseEntity<Object>(new AccountExceptions(ex.message, HttpStatus.CONFLICT.value()), HttpStatus.CONFLICT)
        else {
            new ResponseEntity<Object>(new AccountExceptions(ex.message, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    private notificarFila(String message){
        AWSCredentialsProvider provider = new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsKey, awsPass))
        AmazonSQS amazonSQS = AmazonSQSClientBuilder.standard().withRegion("us-east-2").withCredentials(provider).build()
        SendMessageResult  result = amazonSQS.sendMessage(sqsUrl, message)

    }
}
