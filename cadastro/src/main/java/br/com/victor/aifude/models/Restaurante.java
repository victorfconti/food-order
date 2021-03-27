package br.com.victor.aifude.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "restaurantes")
public class Restaurante extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String proprietario;
    public String cnpj;
    public String nome;
    @OneToOne(cascade = CascadeType.ALL)
    public Localizacao localizacao;
    @CreationTimestamp
    public LocalDateTime dataCriacao;
    @UpdateTimestamp
    public LocalDateTime dataAtualizacao;
    @OneToMany(mappedBy = "restaurante")
    public List<Prato> pratos;


}
