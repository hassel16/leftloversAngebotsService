package dhbw.leftlovers.angebotsservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "tbl_angebot")
public class Angebot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long angebotid;

    private String titel;

    private String description;

    private LocalDateTime createdatetime;

    @ManyToOne
    @JoinColumn(name = "tbl_kategorie_kategorieid", nullable = false)
    private Kategorie kategorie;

    private double preis;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "tbl_foto_fotoid")
    private Foto foto;

    @ManyToOne
    @JoinColumn(name = "tbl_user_userid",nullable = false)
    private User user;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "tbl_standort_standortid",nullable = false)
    private Standort city;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    public LocalDateTime getCreatedatetime() {
        return this.createdatetime;
    }

    @Transient
    private Double entfernung;

    public void setEntfernung(double latU,double lngU){
        this.entfernung  = this.abstandInKm(latU, lngU);
    }

    public boolean isInRadius(double latU,double lngU,long radius){

        setEntfernung(latU, lngU);

        if((double)radius <= this.entfernung){
            return true;
        }else{
            return false;
        }
    }

    public boolean isInRadius(long radius){
        if((double)radius <= this.entfernung){
            return true;
        }else{
            return false;
        }
    }

    public double abstandInKm(double latU,double lngU){

        final String uri = "https://leftloversgateway.azurewebsites.net/StandortService/Abstandsberechnung";
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(uri)
                // Add query parameter
                .queryParam("lat1",this.city.getLat())
                .queryParam("lon1",this.city.getLng())
                .queryParam("lat2", latU)
                .queryParam("lon2",lngU);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(builder.toUriString(), Double.class);
    }
}
