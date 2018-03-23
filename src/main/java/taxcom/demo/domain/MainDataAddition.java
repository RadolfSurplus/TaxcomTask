package taxcom.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Дополнительная сущность - дочерний узел. Связь с родителем идет по принципу Many-to-One
@Entity
@Table(name = "additions")
public class MainDataAddition {

    //ID игнорируется при пересылке аннотацией @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    private Long value;

    //Поле для организации зависимости Many-to-One, указано аннотацией @JsonBackReference
    //Отсылка на родителя хранится в ячейке main_id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "main_id", nullable = false)
    @JsonBackReference
    private MainData mainData;

    public MainDataAddition() {
    }

    public MainDataAddition(String name, Long value) {
        this.name = name;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public MainData getMainData() {
        return mainData;
    }

    public void setMainData(MainData mainData) {
        this.mainData = mainData;
    }
}
