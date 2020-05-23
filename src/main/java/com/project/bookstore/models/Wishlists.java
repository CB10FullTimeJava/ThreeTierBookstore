/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookstore.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chatz
 */
@Entity
@Table(name = "wishlists")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wishlists.findAll", query = "SELECT w FROM Wishlists w")
    , @NamedQuery(name = "Wishlists.findById", query = "SELECT w FROM Wishlists w WHERE w.id = :id")})
public class Wishlists implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wishlistId")
    private Collection<WishlistItems> wishlistItemsCollection;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private Users userId;

    public Wishlists() {
    }

    public Wishlists(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<WishlistItems> getWishlistItemsCollection() {
        return wishlistItemsCollection;
    }

    public void setWishlistItemsCollection(Collection<WishlistItems> wishlistItemsCollection) {
        this.wishlistItemsCollection = wishlistItemsCollection;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
        if (!(object instanceof Wishlists)) {
            return false;
        }
        Wishlists other = (Wishlists) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.bookstore.models.Wishlists[ id=" + id + " ]";
    }
    
}
