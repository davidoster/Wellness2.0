package com.afdemp.wellness.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
@Table(name = "products", catalog = "wellness2.0", schema = "")
//@XmlRootElement
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private int productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title",nullable = false, length = 45)
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price",nullable = false)
    private double price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "short_description",nullable = false, length = 200)
    private String shortDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "details",nullable = false, length = 500)
    private String details;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duration", nullable = false)
    private int duration;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String category;

   
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    private List<PurchaseDetails> purchaseDetailsList;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(int productId, String title, double price, String shortDescription, String details, int duration, String category) {
        this.productId = productId;
        this.title = title;
        this.price = price;
        this.shortDescription = shortDescription;
        this.details = details;
        this.duration = duration;
        this.category = category;
    }

    public Product(String title, double price, String shortDescription, String details, int duration, String category, List<PurchaseDetails> orderdetailsList) {
        this.title = title;
        this.price = price;
        this.shortDescription = shortDescription;
        this.details = details;
        this.duration = duration;
        this.category = category;
        this.purchaseDetailsList = purchaseDetailsList;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<PurchaseDetails> getOrderdetailsList() {
        return purchaseDetailsList;
    }

    public void setOrderdetailsList(List<PurchaseDetails> purchaseDetailsList) {
        this.purchaseDetailsList = purchaseDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.productId;
        hash = 67 * hash + Objects.hashCode(this.title);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.shortDescription);
        hash = 67 * hash + Objects.hashCode(this.details);
        hash = 67 * hash + this.duration;
        hash = 67 * hash + Objects.hashCode(this.category);
        hash = 67 * hash + Objects.hashCode(this.purchaseDetailsList);
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
        final Product other = (Product) obj;
        if (this.productId != other.productId) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.duration != other.duration) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.shortDescription, other.shortDescription)) {
            return false;
        }
        if (!Objects.equals(this.details, other.details)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.purchaseDetailsList, other.purchaseDetailsList)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", title=" + title + ", price=" + price + ", shortDescription=" + shortDescription + ", details=" + details + ", duration=" + duration + ", category=" + category + ", orderdetailsList=" + purchaseDetailsList + '}';
    }

    
        
            
}