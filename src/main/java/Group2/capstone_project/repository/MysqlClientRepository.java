package Group2.capstone_project.repository;

import Group2.capstone_project.domain.Client;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class MysqlClientRepository implements ClientRepository{

    private final JdbcTemplate jdbcTemplate;

    public MysqlClientRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void save(Client client) {
        String sql = "INSERT INTO client(id,name,age,studentNumber,pwd) values(?,?,?,?,?)";
        jdbcTemplate.update(sql,client.getId(),client.getName(),client.getAge(),client.getStudentNumber(),client.getPwd());
    }

    @Override
    public Optional<Client> findId(String name, String studentNumber, String age) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> findPwd(String name, String id, String studentNumber) {
        return Optional.empty();
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public Optional<Client> findById(String id) {
        return Optional.empty();
    }
}
