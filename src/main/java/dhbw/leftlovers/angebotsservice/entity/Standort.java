package dhbw.leftlovers.angebotsservice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

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

    @Basic
    @Column(name = "longitude")
    private double lng;

    @Basic
    @Column(name = "latitude")
    private double lat;
}
