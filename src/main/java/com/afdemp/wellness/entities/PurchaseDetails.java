package com.afdemp.wellness.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;


@Entity
@Transactional
@Table(name="purchase_details", catalog = "wellness2.0", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"purchase_id", "product_id"})})


public class PurchaseDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    private int quantity;
    @JsonIgnore
    @JoinColumn(name = "purchase_id", referencedColumnName = "purchase_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Purchase purchase;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Product product;

    public PurchaseDetails() {
    }

    public PurchaseDetails(Integer id) {
        this.id = id;
    }

    public PurchaseDetails(Integer id, int quantity, Purchase purchase, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.purchase = purchase;
        this.product = product;
    }

    public PurchaseDetails(Integer id, Purchase purchase) {
        this.id = id;
        this.purchase = purchase;
    }

    public PurchaseDetails(Integer id, Product product) {
        this.id = id;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + this.quantity;
        hash = 43 * hash + Objects.hashCode(this.purchase);
        hash = 43 * hash + Objects.hashCode(this.product);
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
        final PurchaseDetails other = (PurchaseDetails) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.purchase, other.purchase)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PurchaseDetails{" + "id=" + id + ", quantity=" + quantity + ", purchase=" + purchase + ", product=" + product + '}';
    }

    

   
}
