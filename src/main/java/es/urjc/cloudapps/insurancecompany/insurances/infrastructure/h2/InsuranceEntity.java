package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.h2;

import es.urjc.cloudapps.insurancecompany.clients.infrastructure.postgres.ClientEntity;
import es.urjc.cloudapps.insurancecompany.incidences.infrastructure.h2.IncidenceEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "insurances")
@Getter
@Setter
public class InsuranceEntity {

    @Id
    private String id;

    @OneToOne
    private ClientEntity client;

    @NaturalId
    private String houseRegistry;

    private String houseCountry;

    private String houseCity;

    private String housePostalCode;

    private String houseStreet;

    private String houseNumber;

    @ManyToMany
    @JoinTable(
            name = "insurances_and_coverages",
            joinColumns = @JoinColumn(name = "insurance_id"),
            inverseJoinColumns = @JoinColumn(name = "coverage_id")
    )
    private Set<CoverageEntity> coverages;

    @OneToMany
    private Set<IncidenceEntity> incidences;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public String getHouseRegistry() {
        return houseRegistry;
    }

    public void setHouseRegistry(String houseRegistry) {
        this.houseRegistry = houseRegistry;
    }

    public String getHouseCountry() {
        return houseCountry;
    }

    public void setHouseCountry(String houseCountry) {
        this.houseCountry = houseCountry;
    }

    public String getHouseCity() {
        return houseCity;
    }

    public void setHouseCity(String houseCity) {
        this.houseCity = houseCity;
    }

    public String getHousePostalCode() {
        return housePostalCode;
    }

    public void setHousePostalCode(String housePostalCode) {
        this.housePostalCode = housePostalCode;
    }

    public String getHouseStreet() {
        return houseStreet;
    }

    public void setHouseStreet(String houseStreet) {
        this.houseStreet = houseStreet;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Set<CoverageEntity> getCoverages() {
        return coverages;
    }

    public void setCoverages(Set<CoverageEntity> coverages) {
        this.coverages = coverages;
    }

    public Set<IncidenceEntity> getIncidences() {
        return incidences;
    }

    public void setIncidences(Set<IncidenceEntity> incidences) {
        this.incidences = incidences;
    }
}
