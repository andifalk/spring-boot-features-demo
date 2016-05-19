package net.andreasfalk.oauth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@EnableAuthorizationServer
@EnableResourceServer
@SpringBootApplication
@RestController
public class SpringBootOauthServerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOauthServerDemoApplication.class, args);
	}

    @RequestMapping(path = "/restricted")
    public String restricted() {
        return "restricted resource";
    }

    @RequestMapping(path = "/user")
    public Principal user(Principal principal) {
        return principal;
    }
}
