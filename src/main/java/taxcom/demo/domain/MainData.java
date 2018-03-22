package taxcom.demo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "data")
public class MainData {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mainData")
    @JsonManagedReference
    private List<MainDataAddition> dataAdditions = new ArrayList<>();

    public MainData() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
