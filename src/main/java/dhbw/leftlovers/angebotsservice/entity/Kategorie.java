package dhbw.leftlovers.angebotsservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_kategorie")
public class Kategorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long kategorieid;

    private String titel;
}
