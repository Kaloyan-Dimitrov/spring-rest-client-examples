package guru.springframework.springrestclientexamples.controllers;

import guru.springframework.springrestclientexamples.services.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

import java.util.concurrent.ExecutionException;

/**
 * Created by jt on 9/22/17.
 */
@Slf4j
@Controller
public class UserController {

    private ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"", "/", "/index"})
    public String index(){
        return "index";
    }

    @PostMapping("/users")
    public String formPost(Model model, ServerWebExchange serverWebExchange) throws ExecutionException, InterruptedException {
        log.debug("Received post request");

        MultiValueMap<String, String> map = serverWebExchange.getFormData().toFuture().get();

        assert map != null;
        int limit = Integer.parseInt(map.get("limit").get(0));

        log.debug("Received Limit value: " + limit);
        //default if null or zero
        if(limit == 0){
            log.debug("Setting limit to default of 10");
            limit = 10;
        }

        model.addAttribute("users", apiService.getUsers(limit));

        return "userlist";
    }
}
