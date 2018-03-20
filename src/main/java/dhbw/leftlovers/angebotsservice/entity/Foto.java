package dhbw.leftlovers.angebotsservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_foto")
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fotoid;

    private String fotourl;
}
