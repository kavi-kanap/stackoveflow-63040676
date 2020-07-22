package com.example.another;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class AccessingDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AccessingDataJpaApplication.class);
		Table1Repository repo = context.getBean(Table1Repository.class);

		Table1 table1 = repo.save(new Table1(1l));
		Table2 table2 = new Table2(new Table2Key(1l, "field1"), table1);
		table2.setTable1(table1);
		table1.setReferences(Collections.singletonList(table2));
		repo.save(table1);

		Table1 table1_2 = repo.save(new Table1(2l));
		Table2 table2_2 = new Table2(new Table2Key(2l, "field2"), table1_2);
		table2.setTable1(table1_2);
		table1_2.setReferences(Collections.singletonList(table2_2));
		Table2 table2_3 = new Table2(new Table2Key(2l, "field3"), table1_2);
		table2_3.setTable1(table1_2);
		table1_2.setReferences(Arrays.asList(table2_2, table2_3));
		repo.save(table1_2);

		Table1Service service = context.getBean(Table1Service.class);
		System.out.println(service.findAll());

	}

}