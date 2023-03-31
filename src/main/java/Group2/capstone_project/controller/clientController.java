package Group2.capstone_project.controller;

import Group2.capstone_project.domain.Client;
import Group2.capstone_project.service.clientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class clientController {

    private final PasswordEncoder passwordEncoder;
    private final clientService clientserivce;

    @Autowired
    public clientController(clientService clientService,PasswordEncoder passwordEncoder){
        this.clientserivce = clientService;
        this.passwordEncoder=passwordEncoder;
    }

    @GetMapping("/client/login")
    public String login(){
        return "/client/login";
    }

    @GetMapping("/client/register")
    public String register(){
        return "/client/register";
    }

    @GetMapping("/client/findAccount")
    public String findAccount(){
        return  "/client/findAccount";
    }

    @PostMapping("/client/join")
    public String create(clientForm clientForm){
        Client client = new Client();
        client.setId(clientForm.getId());
        client.setName(clientForm.getName());
        client.setAge(clientForm.getAge());
        client.setStudentNumber(clientForm.getStudentNumber());
        client.setPwd(passwordEncoder.encode(clientForm.getPassword()));

        clientserivce.join(client);

        return "redirect:/client/login";
    }

    @GetMapping("/client")
    public String list(Model model){
        List<Client> clients = clientserivce.findAll();
        model.addAttribute("clients",clients);
        return "client/clientlist";
    }

    @GetMapping("client/findID")
    public String findID(Model model, clientForm clientForm){
        Client client = new Client();
        client.setName(clientForm.getName());
        client.setStudentNumber(clientForm.getStudentNumber());
        client.setAge(clientForm.getAge());
        String result = clientserivce.findId(client.getName(), clientForm.getStudentNumber(), client.getAge());

        model.addAttribute("result",result);
        return "client/checkyourId";
    }

    @GetMapping("client/findPwd")
    public String findPwd(Model model, clientForm clientForm){
        Client client = new Client();
        client.setName(clientForm.getName());
        client.setId(clientForm.getId());
        client.setStudentNumber(clientForm.getStudentNumber());
        String result = clientserivce.findPwd(client.getName(), client.getId(), clientForm.getStudentNumber());
        model.addAttribute("result",result);
        return "client/checkyourPwd";
    }

}
