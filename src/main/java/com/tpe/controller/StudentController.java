package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.StudentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students") //http://localhost:8080/students
public class StudentController {
    @Autowired
    private StudentService studentService;

    //Butun ogrenciler gelsin.

    @GetMapping//http://localhost:8080/students + GET
    public ResponseEntity<List<Student>> getAll(){

        List<Student> students = studentService.getAll();

        return ResponseEntity.ok(students);//200 kodunu HTTp Status kodu. Her sey OK demek.
    }

    //Student save etme
    @PostMapping//endpoint e gerek yok. http://localhost:8080/students + GET + JSON
    public ResponseEntity<Map<String,String>> createStudent(@Valid @RequestBody Student student){//Parametre kismi cok onemli. Biz aslinda JOSN olan datayi Student objesine mapledik.
        //@Valid parameterler valid mi kontrol ede bu ornekte Student objesi
        //olusturmak icin gonderilen filedlar yani
        //name gibi ozellikler duzgun set edilmis mi ona bakar
        //@RequestBody gelen parametreyi requestin bodysindeki bilgisi
        //Student objesine map edilmesini sagliyor.
        studentService.createStudent(student);//bu cmethodu yazdik servicete olusturduk.Oradan da repoya gittik.
        Map<String,String> map = new HashMap<>();//Mesajlari yazmak icin Map objesi olusturduk.
        map.put("message","Student is created succesfully");//ilk mesaj
        map.put("status","true");//ikinci mesaj status kodu frontende gelmesi icin.

        return new ResponseEntity<>(map, HttpStatus.CREATED);

    }

    //Id ile ogrenci getirelim
    @GetMapping("/query")
    public ResponseEntity<Student> getStudent(@RequestParam("id") Long id){//Request param ile
        Student student = studentService.findStudent(id);
        return ResponseEntity.ok(student);//ok calisir cunku direkt obje donecek
    }



}
