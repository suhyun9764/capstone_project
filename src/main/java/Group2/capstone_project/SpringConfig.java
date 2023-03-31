package Group2.capstone_project;

import Group2.capstone_project.repository.ClientRepository;
import Group2.capstone_project.repository.MemoryClientRepository;
import Group2.capstone_project.repository.MysqlClientRepository;
import Group2.capstone_project.service.clientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public clientService clientService(){
        return new clientService(clientRepository());
    }

    @Bean
    public ClientRepository clientRepository(){
        return new MysqlClientRepository(dataSource);
    }


}
