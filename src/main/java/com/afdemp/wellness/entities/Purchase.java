package com.afdemp.wellness.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;


@Entity
@Transactional
@Table(name = "purchases", catalog = "wellness2.0", schema = "")

public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short pending;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchase", fetch = FetchType.LAZY)
    private List<PurchaseDetails> purchaseDetailsList;
  
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Customer customer;

    public Purchase() {
    }

    public Purchase(Integer id, Date date, short pending, List<PurchaseDetails> purchaseDetailsList, Customer customer) {
        this.id = id;
        this.date = date;
        this.pending = pending;
        this.purchaseDetailsList = purchaseDetailsList;
        this.customer = customer;
    }

    public Purchase(Integer id, Date date, short pending, Customer customer) {
        this.id = id;
        this.date = date;
        this.pending = pending;
        this.customer = customer;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public short getPending() {
        return pending;
    }

    public void setPending(short pending) {
        this.pending = pending;
    }

    public List<PurchaseDetails> getPurchaseDetailsList() {
        return purchaseDetailsList;
    }

    public void setPurchaseDetailsList(List<PurchaseDetails> purchaseDetailsList) {
        this.purchaseDetailsList = purchaseDetailsList;
    }

    public void addPurchaseDetailsToList(PurchaseDetails pd){
        this.purchaseDetailsList.add(pd);
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.date);
        hash = 61 * hash + this.pending;
        hash = 61 * hash + Objects.hashCode(this.purchaseDetailsList);
        hash = 61 * hash + Objects.hashCode(this.customer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Purchase other = (Purchase) obj;
        if (this.pending != other.pending) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.purchaseDetailsList, other.purchaseDetailsList)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Purchase{" + "id=" + id + ", date=" + date + ", pending=" + pending + ", purchaseDetailsList=" + purchaseDetailsList + ", customer=" + customer + '}';
    }


    
    
}
