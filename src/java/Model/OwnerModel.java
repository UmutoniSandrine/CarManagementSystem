/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DataBaseDao.OwnerDao;
import Domain.Owner;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author bitwayiki
 */
@ManagedBean
@SessionScoped
public class OwnerModel {
    private Owner ow ;
    
    private List<Owner> owners = OwnerDao.findAll();
    

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }
    

    public OwnerModel() {
        this.ow= new Owner();
    }
    
    

    public Owner getOw() {
        return ow;
    }

    public void setOw(Owner ow) {
        this.ow = ow;
    }
    
    public String registerOwner(){
        OwnerDao.createOwner(ow);
        ow = new Owner();
        owners=OwnerDao.findAll();
        return"Owner.xhtml?faces-redirect=true";
    }
    
    
    
}
