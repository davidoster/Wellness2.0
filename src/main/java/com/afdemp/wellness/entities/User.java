package com.afdemp.wellness.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.transaction.annotation.Transactional;


@Entity
@Transactional
@Table(name = "APP_USER", catalog = "wellness2.0", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sso_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
    , @NamedQuery(name = "User.findBySsoId", query = "SELECT u FROM User u WHERE u.ssoId = :ssoId")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "sso_id", nullable = false, length = 30)
    private String ssoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String password;
    @JoinTable(name = "APP_USER_USER_PROFILE", joinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "user_profile_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<UserProfile> userProfileList;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Customer customer;
    /*
    πρόσθεσα το cascade=CascadeType.ALL γιατί όταν πήγαινα να καταχωρήσω τη regitration form έβγαζε error
    org.hibernate.TransientPropertyValueException: Not-null property references a transient value
    https://stackoverflow.com/questions/19074278/not-null-property-references-a-transient-value-transient-instance-must-be-save
    https://stackoverflow.com/questions/32794600/not-null-property-references-a-transient-value-transient-instance-must-be-saved?rq=1
    */
    
    
    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String ssoId, String password) {
        this.id = id;
        this.ssoId = ssoId;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

//    @XmlTransient
    public List<UserProfile> getUserProfileList() {
        return userProfileList;
    }

    public void setUserProfileList(List<UserProfile> userProfileList) {
        this.userProfileList = userProfileList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", ssoId=" + ssoId + ", password=" + password +'}';
    }

    
    
}
