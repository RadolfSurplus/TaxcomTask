package taxcom.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

//Основная сущность. Ключевым полем в БД является UUID, соединение с дочерними узлами идет по принципу One-to-Many
@Entity
@Table(name = "main")
public class MainData {

    //ID игнорируется при пересылке аннотацией @JsonIgnore
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @JsonIgnore
    private UUID id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    //Поле для организации зависимости One-to-Many, указано аннотацией @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mainData")
    @JsonManagedReference
    private List<MainDataAddition> data = new ArrayList<>();

    public MainData() {
    }

    public UUID getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<MainDataAddition> getData() {
        return data;
    }

    public void setData(List<MainDataAddition> data) {
        this.data = data;
    }
}
