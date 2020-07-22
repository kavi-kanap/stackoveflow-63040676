package com.example.another;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Table2Key implements Serializable {
    public Table2Key() {
    }

    public Table2Key(Long t1Id, String field1) {
        this.t1Id = t1Id;
        this.field1 = field1;
    }

    public Long getT1Id() {
        return t1Id;
    }

    public void setT1Id(Long t1Id) {
        this.t1Id = t1Id;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    @Column(name = "T1_ID")
    private Long t1Id;

    @Column(name = "FIELD1")
    private String field1;

    @Override
    public String toString() {
        return "Table2Key{" +
                "t1Id=" + t1Id +
                ", field1='" + field1 + '\'' +
                '}';
    }
}
