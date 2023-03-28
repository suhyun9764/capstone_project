package Group2.capstone_project.repository;

import Group2.capstone_project.domain.Client;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemoryClientRepositoryTest {

    MemoryClientRepository repository = new MemoryClientRepository();

    @Test
    void save() {
        //given
        Client client1 = new Client();
        client1.setName("수현");
        client1.setAge("980129");
        client1.setId("suhyun9764");
        client1.setStudentNumber("20201496");
        //when
        repository.save(client1);
        //then

        Client result = repository.findId(client1.getName(), client1.getStudentNumber(),client1.getAge()).get();
        Assertions.assertThat(result).isEqualTo(client1);
    }

    @Test
    void findId() {

    }
}