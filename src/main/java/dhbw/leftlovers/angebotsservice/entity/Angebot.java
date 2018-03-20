package dhbw.leftlovers.angebotsservice.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tbl_angebot")
public class Angebot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long angebotid;

    @Basic
    private String titel;

    private String description;

    private LocalDateTime createdatetime;

    @ManyToOne
    @JoinColumn(name = "tbl_kategorie_kategorieId")
    private Kategorie kategorie;

    @OneToOne
    @JoinColumn(name = "tbl_foto_fotoid")
    private Foto foto;

    @Column(name = "tbl_user_userid",nullable = false)
    private long userid;

}
