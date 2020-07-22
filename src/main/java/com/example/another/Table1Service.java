package com.example.another;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Table1Service {
    @Autowired
    Table1Repository repository;

    @Transactional
    public List<Table1> findAll(){
        List<Table1> all = repository.findAll();
        all.forEach(item -> item.getReferences().forEach(Table2::getId));
        return all;
    }
}
