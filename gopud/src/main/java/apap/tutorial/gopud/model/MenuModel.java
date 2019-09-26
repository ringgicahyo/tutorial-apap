package apap.tutorial.gopud.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.FetchType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "menu")
public class MenuModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Column(name = "harga", nullable = false)
    private BigInteger harga;

    @NotNull
    @Column(name = "durasiMasak", nullable = false)
    private Integer durasiMasak;

    @NotNull
    @Size(max = 50)
    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "restoranId", referencedColumnName = "idRestoran", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private RestoranModel restoran;

    // public MenuModel() {
    // }

    // public MenuModel(Long id, String nama, BigInteger harga, Integer durasiMasak, String deskripsi, RestoranModel restoran) {
    //     this.id = id;
    //     this.nama = nama;
    //     this.harga = harga;
    //     this.durasiMasak = durasiMasak;
    //     this.deskripsi = deskripsi;
    //     this.restoran = restoran;
    // }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public BigInteger getHarga() {
        return this.harga;
    }

    public void setHarga(BigInteger harga) {
        this.harga = harga;
    }

    public Integer getDurasiMasak() {
        return this.durasiMasak;
    }

    public void setDurasiMasak(Integer durasiMasak) {
        this.durasiMasak = durasiMasak;
    }

    public String getDeskripsi() {
        return this.deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public RestoranModel getRestoran() {
        return this.restoran;
    }

    public void setRestoran(RestoranModel restoran) {
        this.restoran = restoran;
    }

}