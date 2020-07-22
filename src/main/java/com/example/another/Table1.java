package com.example.another;

import javax.persistence.*;
import java.util.List;

@Entity
public class Table1 {

    @Id
    @Column
    private Long id;

    @OneToMany(mappedBy = "table1", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Table2> references;

    public Table1(Long id, List<Table2> references) {
        this.id = id;
        this.references = references;
    }

    public Table1(Long id) {
        this.id = id;
    }

    public Table1() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Table2> getReferences() {
        return references;
    }

    public void setReferences(List<Table2> references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return "Table1{" +
                "id=" + id +
                ", references=" + references +
                '}';
    }
}
