package br.com.estagginc.estagg_api.view;


import br.com.estagginc.estagg_api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("alunos")
public class PersonControllerView {
    @Autowired
    private PersonService service;

    @GetMapping
    public String returnAlunos(Model model){
        model.addAttribute("people", this.service.findAllDeletedFalse());
        return "alunos";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    private String deleteStudent(@RequestParam String id){
        this.service.delete(Long.parseLong(id));
        System.out.println("Student_Id : "+id);
        return "redirect:/alunos";
    }

}
