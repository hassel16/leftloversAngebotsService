package dhbw.leftlovers.angebotsservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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

        final String uri = "https://leftloversgateway.azurewebsites.net/StandortService/Abstandsberechnung";
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(uri)
                // Add query parameter
                .queryParam("lat1",this.lat)
                .queryParam("lon1",this.lng)
                .queryParam("lat2", latU)
                .queryParam("lon2",lngU);

        RestTemplate restTemplate = new RestTemplate();
        Double abstandInKm= restTemplate.getForObject(builder.toUriString(), Double.class);
        if((double)radius <= abstandInKm){
            return true;
        }else{
            return false;
        }
    }
}
