package com.orders.orders.Controller;


import com.entities.common.common_entities.UserService.UserDetails;
import com.orders.orders.Clients.UserClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/order")
@RequiredArgsConstructor
public class CreateOrder {

    private final UserClient userClient;

    private final Map<Integer,String> useOrderMap =  new HashMap<>();

    @GetMapping
    public String getYourOrder(){
        return "your order";
    }

    @GetMapping("/users")
    public List<UserDetails> getUserNames(){
        return userClient.getUsers();
    }

    @PostMapping("/create")
    public void createOrder(Integer userId, String orderName){
        useOrderMap.put(userId,orderName);
        log.info("order created", useOrderMap);
    }

}
