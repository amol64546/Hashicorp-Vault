package com.hashicorp.vault;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
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

  @Autowired
  VaultTransit vaultTransit;


  @PostMapping
  Collection<Person> put(@RequestBody Person person) {
    Person p = Person.builder()
      .id(person.getId())
        .name(person.getName())
        .username(vaultTransit.encrypt(person.getUsername()))
        .password(vaultTransit.encrypt(person.getPassword()))
      .build();
    personRepo.save(p);
    return personRepo.findAll();
  }


  @GetMapping
  List<Map<String, Object>>get() {
    return jdbcTemplate.queryForList("SELECT * FROM person");
  }
}



