package Group2.capstone_project.service;

import Group2.capstone_project.domain.Client;
import Group2.capstone_project.repository.ClientRepository;
import Group2.capstone_project.repository.MemoryClientRepository;
import Group2.capstone_project.repository.MysqlClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class clientServiceTest {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private DataSource dataSource;
    private final ClientRepository clientRepository = new MemoryClientRepository();

    clientService clientService = new clientService(clientRepository);

    @Test
    void join() {
        Client client = new Client();
        client.setStudentNumber("20201496");
        client.setId("suhyun9764");
        client.setAge("980129");
        client.setPwd("asdf9764");



        System.out.println("");
        clientService.join(client);

        List<Client> result = clientService.findAll();
        System.out.println(result.get(0).getId());

    }
    @Test
    void findId() {
    }

    @Test
    void findPwd() {
    }

    @Test
    void findAll() {
    }
}