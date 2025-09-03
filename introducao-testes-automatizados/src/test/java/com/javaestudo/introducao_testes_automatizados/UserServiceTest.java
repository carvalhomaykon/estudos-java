package com.javaestudo.introducao_testes_automatizados;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceTest {

    private UserService userService = new UserService();

    @Test
    public void createUser_ReturnUsers(){
        // AAA
        // Arange (Onde eu monto os dados que irei usar nos testes)
        User user = new User("maykoncarvalho", "123456");

        // Act (Momento que eu voi agir, exercitar)
        List<User> users = userService.create(user);

        // Assert (Verificar o teste)
        // JUnit
        assertEquals(1, users.size()); // Verifica se a quantidade de nomes inseridos é igual à 1
        assertEquals(user, users.get(0));
    }

    @Test
    public void createUser_ThrowsException(){
        User user = new User("maykoncarvalho", "123456");
        userService.create(user);

        assertThrows(RuntimeException.class,
                () -> userService.create(user));
    }

}
