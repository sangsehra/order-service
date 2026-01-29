package com.orders.orders.Clients;

import com.entities.common.common_entities.UserService.UserDetails;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface UserClient {
    @GetExchange("/user/users")
    List<UserDetails> getUsers();
}
