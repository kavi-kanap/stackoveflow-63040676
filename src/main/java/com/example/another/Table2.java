package com.example.another;

import javax.persistence.*;

@Entity
public class Table2 {

    @EmbeddedId
    private Table2Key id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "T1_ID", insertable = false, updatable = false)
    private Table1 table1;

    public Table2() {
    }

    public Table2(Table2Key id, Table1 table1) {
        this.id = id;
        this.table1 = table1;
    }

    public Table2Key getId() {
        return id;
    }

    public void setId(Table2Key id) {
        this.id = id;
    }

    public Table1 getTable1() {
        return table1;
    }

    public void setTable1(Table1 table1) {
        this.table1 = table1;
    }

    @Override
    public String toString() {
        return "Table2{" +
                "id=" + id +
                '}';
    }
}
