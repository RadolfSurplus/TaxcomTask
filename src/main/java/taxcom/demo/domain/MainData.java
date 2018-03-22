package taxcom.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "data")
public class MainData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mainData")
    @JsonManagedReference
    private List<MainDataAddition> dataAdditions = new ArrayList<>();

    public MainData() {
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<MainDataAddition> getDataAdditions() {
        return dataAdditions;
    }

    public void setDataAdditions(List<MainDataAddition> dataAdditions) {
        this.dataAdditions = dataAdditions;
    }
}
