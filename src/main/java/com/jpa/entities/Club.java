package com.jpa.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Entity
@Table(name = "clubs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToOne(targetEntity = Coach.class , cascade = CascadeType.PERSIST) //TARGET ENTITY ES PARA DECIRLE A JPA A QUE CLASE VA A APUNTAR LA RELACION ,
    // CASCADE PERSIST HACE QUE SE MODIFIQUE EL OBJETO COACH SOLO CUANDO SE PERSISTE EN BASE DE DATOS
    @JoinColumn(name = "id_coach") //CON JOIN COLUMN PERSONALIZAMOS LA COLUMNA DEL COACH EN LA TABLA DE CLUBES
    Coach coach;

    @OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY, mappedBy = "club")   //EL FETCH LAZY DETERMINA QUE CUANDO OBTENGAMOS EL OBJETO DE LA BASE DE DATOS,
    // EL ATRIBUTO PLAYERS LO OBTENDREMOS SOLO SI LO PEDIMOS EXPLICITAMENTE
    List<Player> players;

    @ManyToOne(targetEntity = FootballAssociation.class)
    FootballAssociation footballAssociation;

    @ManyToMany(targetEntity = FootballCompetition.class, fetch = FetchType.LAZY)
            @JoinTable(name = "club_competitions", joinColumns = @JoinColumn(name = "club"), inverseJoinColumns = @JoinColumn(name = "competition")) //CON JOINTABLE LE CAMBIAMOS
    // EL NOMBRE A LA TABLA , CON JOINCOLUMNS LE CAMBIAMOS EL NOMBRE A LA COLUMNA QUE TIENE EL ID DE ESTA TABLA(CLUBS) Y CON INVERSE LE CAMBIAMOS EL NOMBRE A LA OTRA(FUTBOLCOMPETITIONS)
    List<FootballCompetition> footballCompetitions;



}
