package Group2.capstone_project.repository;

import Group2.capstone_project.domain.Client;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String sql = "SELECT * FROM client where name = name and studentNumber = studentNumber and age = age";
        List<Client> result = jdbcTemplate.query(sql,clientRowMapper());
        return result.stream().findAny();

    }

    @Override
    public Optional<Client> findPwd(String name, String id, String studentNumber) {
        String sql = "SELECT * FROM client where name = name and id = id and studentNumber = studentNumber";
        List<Client> result = jdbcTemplate.query(sql,clientRowMapper());
        return result.stream().findAny();
    }

    @Override
    public List<Client> findAll() {
        String sql = "SELECT * FROM client";
        return jdbcTemplate.query(sql,clientRowMapper());
    }

    @Override
    public Optional<Client> findById(String id) {
        return Optional.empty();
    }

    private RowMapper<Client> clientRowMapper(){
        return (rs, rowNum) -> {

            Client client = new Client();
            client.setId(rs.getString("id"));
            client.setName(rs.getString("name"));
            client.setStudentNumber(rs.getString("studentNumber"));
            client.setAge(rs.getString("age"));
            client.setPwd(rs.getString("pwd  "));


            return client;
        };
    }
}
