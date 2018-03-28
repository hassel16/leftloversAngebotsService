package dhbw.leftlovers.angebotsservice.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@Table(name = "tbl_angebot")
public class Angebot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long angebotid;

    private String titel;

    private String description;

    private LocalDateTime createdatetime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_kategorie_kategorieid", nullable = false)
    private Kategorie kategorie;

    private double preis;

    @OneToOne
    @JoinColumn(name = "tbl_foto_fotoid")
    private Foto foto;

    @ManyToOne
    @JoinColumn(name = "tbl_user_userid",nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "tbl_standort_standortid",nullable = false)
    private Standort standort;

    public String getCreatedatetime(){
         final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
         return DATE_FORMAT.format(createdatetime);
    }
}
