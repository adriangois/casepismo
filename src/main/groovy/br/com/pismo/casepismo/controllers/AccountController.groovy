package br.com.pismo.casepismo.controllers

import br.com.pismo.casepismo.exceptions.AccountExceptions
import br.com.pismo.casepismo.models.Account

import br.com.pismo.casepismo.services.AccountService
import org.springframework.beans.factory.annotation.Autowired
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

    @PostMapping('')
    def create(@RequestBody Account account) throws Exception {
        accountService.create(account)
    }

    @GetMapping('{id}')
    def accountById(@PathVariable long id) {
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
}
