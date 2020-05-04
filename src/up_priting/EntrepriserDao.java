

public class EntreriserDao{


	private String id_;
    private String designation_;
    private String  rccm_ ;
    private String  adressPhysique_;
    private String  adressEmail ;
    private String  contact;

public EntreriserDao(){

}
public EntreriserDao(String id_,String designation_,String rccm_,String adressPhysique_, String adressEmail,String contact){
    this.id_=id_;
    this.designation_=designation_;
    this.rccm_=rccm_;
    this.adressPhysique_=adressPhysique_;
    this.adressEmail=adressEmail;
    this.contact=contact;

}
public void setId_(String id_){
    this.id_=id_;
}
public String getId_(){
    return id_;
}

public void setDesignation_(String designation_){
    this.designation_=designation_;
}

public String getDesignation_(){
    return designation_;
}
public void setRccm_(String rccm_){
    this.rccm_=rccm_;
}
public String getRccm_(){
    return rccm_;
}

public void setAdressPhysique_(String adressPhysique_){
    this.adressPhysique_=adressPhysique_;
}
public String getAdressPhysique_(){
    return adressPhysique_;
}
public void setAdressEmail(String adressEmail){
    this.adressEmail=adressEmail;
}
public String getAdressEmail_(){
    return getAdressEmail_;
}

public void setContact(String contact){
    this.contact=contact;
}
public String getContact(){
    return contact;
}

}