package dhbw.leftlovers.angebotsservice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;

    private String username;


}

