package taxcom.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    private Set<MainDataAddition> dataAdditions = new HashSet<>();

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

    public Set<MainDataAddition> getDataAdditions() {
        return dataAdditions;
    }

    public void setDataAdditions(Set<MainDataAddition> dataAdditions) {
        this.dataAdditions = dataAdditions;
    }
}
