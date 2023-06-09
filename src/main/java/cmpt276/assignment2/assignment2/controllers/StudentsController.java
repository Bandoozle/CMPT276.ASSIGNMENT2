package cmpt276.assignment2.assignment2.controllers;

//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

//import aj.org.objectweb.asm.Attribute;
import cmpt276.assignment2.assignment2.models.Student;
import cmpt276.assignment2.assignment2.models.StudentRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class StudentsController {

    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/students/view") //ENDPOINT
    public String getAllData(Model model){
        System.out.println("Getting all data");
        List<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        return "students/displayData";
    }

    @GetMapping("/students/display") //ENDPOINT
    public String getAllStudents(Model model){
        System.out.println("Getting all data");
        List<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        return "students/displayStudents";
    }
    
    @PostMapping("students/add")
    public String addStudent(@RequestParam Map<String, String> newstudent, HttpServletResponse response){
        System.out.println("ADD student");
        String newName = newstudent.get("name");
        int newWeight = Integer.parseInt(newstudent.get("weight"));
        int newHeight = Integer.parseInt(newstudent.get("height"));
        String newHairColor = newstudent.get("hairColor");
        double newGpa = Double.parseDouble(newstudent.get("gpa"));
        String newEmail = newstudent.get("email");
        String newNationality = newstudent.get("nationality");
        String newNumber = newstudent.get("number");
        String newGender = newstudent.get("gender");
        studentRepo.save(new Student(newName, newWeight, newHeight, newHairColor, newGpa, newEmail, newNationality, newNumber, newGender));
        response.setStatus(201);
        return "redirect:/add.html";
    }

    @GetMapping("/students/update/{uid}") //ENDPOINT
    public String editStudent(Model model, @PathVariable String uid){
        System.out.println("Getting student " + uid);
        Student student = studentRepo.findById(Integer.parseInt(uid)).get();
        model.addAttribute("student", student);
        return "students/updateStudents";
    }
    @PostMapping("/students/{uid}")
    public String updateStudent(@PathVariable String uid,  @RequestParam Map<String, String> oldStudent){
        Student existingStudent = studentRepo.findById(Integer.parseInt(uid)).get();
        existingStudent.setName(oldStudent.get("name"));
        existingStudent.setWeight(Integer.parseInt(oldStudent.get("weight")));
        existingStudent.setHeight(Integer.parseInt(oldStudent.get("height")));
        existingStudent.setHairColor(oldStudent.get("hairColor"));
        existingStudent.setGpa(Double.parseDouble(oldStudent.get("gpa")));
        existingStudent.setEmail(oldStudent.get("email"));
        existingStudent.setNationality(oldStudent.get("nationality"));
        existingStudent.setNumber(oldStudent.get("number"));
        existingStudent.setGender(oldStudent.get("gender"));
        studentRepo.save(existingStudent);

        return "redirect:/students/display";
    }

   @GetMapping("/students/delete/{uid}") //ENDPOINT
    public String deleteStudent(Model model, @PathVariable String uid){
        System.out.println("Deleting student " + uid);
        int id = Integer.parseInt(uid);
        Student student = studentRepo.findById(id).orElse(null);
        if (student != null) {
            studentRepo.delete(student);
        }
        return "redirect:/students/display";
    }
}