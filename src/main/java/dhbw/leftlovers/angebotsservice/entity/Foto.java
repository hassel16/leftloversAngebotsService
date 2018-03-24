package dhbw.leftlovers.angebotsservice.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "tbl_foto")
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fotoid;

    private String fotourl;
}
