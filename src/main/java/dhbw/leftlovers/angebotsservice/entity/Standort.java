package dhbw.leftlovers.angebotsservice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_standort")
public class Standort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long standortid;

    @Basic
    @Column(name = "name")
    private String long_name;

    @Column(name = "name_details")
    private String name_details;

    @Basic
    @Column(name = "longitude")
    private double lng;

    @Basic
    @Column(name = "latitude")
    private double lat;
}
