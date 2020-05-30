package com.afdemp.wellness.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.transaction.annotation.Transactional;


@Entity
@Transactional
@Table(name = "persistent_logins", catalog = "wellness2.0", schema = "")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersistentLogin.findAll", query = "SELECT p FROM PersistentLogin p")
    , @NamedQuery(name = "PersistentLogin.findByUsername", query = "SELECT p FROM PersistentLogin p WHERE p.username = :username")
    , @NamedQuery(name = "PersistentLogin.findBySeries", query = "SELECT p FROM PersistentLogin p WHERE p.series = :series")
    , @NamedQuery(name = "PersistentLogin.findByToken", query = "SELECT p FROM PersistentLogin p WHERE p.token = :token")
    , @NamedQuery(name = "PersistentLogin.findByLastUsed", query = "SELECT p FROM PersistentLogin p WHERE p.lastUsed = :lastUsed")})
public class PersistentLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(nullable = false, length = 64)
    private String username;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(nullable = false, length = 64)
    private String series;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(nullable = false, length = 64)
    private String token;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_used", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUsed;

    public PersistentLogin() {
    }

    public PersistentLogin(String series) {
        this.series = series;
    }

    public PersistentLogin(String series, String username, String token, Date lastUsed) {
        this.series = series;
        this.username = username;
        this.token = token;
        this.lastUsed = lastUsed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (series != null ? series.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersistentLogin)) {
            return false;
        }
        PersistentLogin other = (PersistentLogin) object;
        if ((this.series == null && other.series != null) || (this.series != null && !this.series.equals(other.series))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PersistentLogin{" + "username=" + username + ", series=" + series + ", token=" + token + ", lastUsed=" + lastUsed + '}';
    }

    
    
}
