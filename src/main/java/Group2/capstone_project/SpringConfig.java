package Group2.capstone_project;

import Group2.capstone_project.repository.ClientRepository;
import Group2.capstone_project.repository.MemoryClientRepository;
import Group2.capstone_project.service.clientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public clientService clientService(){
        return new clientService(clientRepository());
    }

    @Bean
    public ClientRepository clientRepository(){
        return new MemoryClientRepository();
    }
}
