package ch.koalix.jointCommissionAccounting_rest.resource;

import ch.koalix.jointCommissionAccounting_rest.model.Account;
import ch.koalix.jointCommissionAccounting_rest.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Component
@Path("accounts")
@XmlRootElement
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAccounts(@Context HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Account> accounts = accountService.getAllAccounts();

        return accounts;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account saveAccount(@Context HttpServletResponse response, Account account) {
        return accountService.saveAccount(account);
    }

    @PUT
    @Path("/{accountId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account updateAccount(@PathParam("accountId") Integer accountId, Account account) {
        return accountService.updateAccount(account, accountId);
    }

    @DELETE
    @Path("/{accountId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAccount(@PathParam("accountId") Integer accountId, Account account) {
        boolean success;

        success = accountService.deleteAccount(accountId);
        if(success) {
            return Response.status(Response.Status.OK).entity(account).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(account).build();
        }
    }
}
