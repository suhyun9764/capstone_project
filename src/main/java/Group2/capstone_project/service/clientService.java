package Group2.capstone_project.service;

import Group2.capstone_project.domain.Client;
import Group2.capstone_project.repository.ClientRepository;
import java.util.List;
import java.util.Optional;


public class clientService {

    private final ClientRepository clientRepository;

    public clientService(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    public void join(Client client){
        validateDuplicateMember(client);
        clientRepository.save(client);
    }

    private void validateDuplicateMember(Client client) {
        clientRepository.findById(client.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 id입니다");
                });
    }

    public String findId(String clientName, String clientStudentNumber, String clientAge ){
        Optional<Client> client = clientRepository.findId(clientName,clientStudentNumber,clientAge);
        return client.get().getId();
    }

    public String findPwd(String clientName, String clientId, String clientStudentNumber ){
        Optional<Client> client = clientRepository.findPwd(clientName,clientId,clientStudentNumber);
        return client.get().getPwd();
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }


}
