package dhbw.leftlovers.angebotsservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_standort")
public class Standort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long standortid;

    @Column(name = "name")
    @JsonProperty("long_name")
    private String longname;

    @Column(name = "name_details")
    private String name_details;

    @Basic
    @Column(name = "longitude")
    private double lng;

    @Basic
    @Column(name = "latitude")
    private double lat;
}
