package dhbw.leftlovers.angebotsservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.boot.jaxb.SourceType;

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

    public boolean isInRadius(double latU,double lngU,long radius){

        int erdradius = 6371;

        double lat = Math.toRadians(latU - this.lat);
        double lon = Math.toRadians(lngU - this.lng);

        double a = Math.sin(lat / 2) * Math.sin(lat / 2) + Math.cos(Math.toRadians(this.lat)) * Math.cos(Math.toRadians(latU)) * Math.sin(lon / 2) * Math.sin(lon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = erdradius * c;

        System.out.println(Math.abs(d));
        if((double)radius <= Math.abs(d)){
            return true;
        }else{
            return false;
        }
    }
}
