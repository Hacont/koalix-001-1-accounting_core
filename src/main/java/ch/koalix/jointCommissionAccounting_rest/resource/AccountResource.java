package ch.koalix.jointCommissionAccounting_rest.resource;

import ch.koalix.jointCommissionAccounting_rest.model.Account;
import ch.koalix.jointCommissionAccounting_rest.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@Component
@Path("accounts")
@XmlRootElement
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Account> getAccounts() {
        ArrayList<Account> accounts = accountService.getAllAccounts();
        return accounts;
    }
}
