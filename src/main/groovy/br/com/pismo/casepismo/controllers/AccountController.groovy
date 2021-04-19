package br.com.pismo.casepismo.controllers

import br.com.pismo.casepismo.models.Account
import br.com.pismo.casepismo.units.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('accounts')
class AccountController {

    @Autowired
    AccountService accountService

    @PostMapping('')
    def create(@RequestBody Account account) throws Exception{
        accountService.create(account)
    }


    @GetMapping('{id}')
    def accountById(@PathVariable long id){
        accountService.findById(id)
    }

}
