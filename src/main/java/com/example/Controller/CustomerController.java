package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class CustomerController {

    @Autowired
    private SessionRegistry sessionRegistry;

    @GetMapping("/index")
    public String index()
    {
        return "Hello Word";
    }

    @GetMapping("/index2")
    public String index2()
    {
        return "Hello Word Not SECURED";
    }

    @GetMapping("/session")
    public ResponseEntity<?> getDetailSession()
    {
        return (ResponseEntity<?>) ResponseEntity.ok();
    }


}
