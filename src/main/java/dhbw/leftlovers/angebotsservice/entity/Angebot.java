package dhbw.leftlovers.angebotsservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Standort standort;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    public LocalDateTime getCreatedatetime() {
        return this.createdatetime;
    }


}
