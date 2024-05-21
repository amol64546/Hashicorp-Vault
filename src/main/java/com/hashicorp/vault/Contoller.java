package com.hashicorp.vault;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class Contoller {

  @Autowired
  PersonRepo personRepo;

  @Autowired
  JdbcTemplate jdbcTemplate;


  @PostMapping
  Collection<Person> put(@RequestBody Person person) {
    personRepo.save(person);
    return personRepo.findAll();
  }

  @GetMapping("/{id}")
  Person get(@PathVariable Integer id) {
    return personRepo.findById(id).orElseThrow();
  }


  @GetMapping
  List<Map<String, Object>> get() {
    return jdbcTemplate.queryForList("SELECT * FROM person");
  }
}



