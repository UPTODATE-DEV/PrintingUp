public class Entrepriser{
PreparedStatement pst;
boolean isSave(Object ob){
   EntrepriserDao entreprise=(EntrepriserDao) ob;
   if(ob instanceof EntrepriserDao){
       pst=conne().PrepareStatement("{Call sp_entrepriser(?,?,?,?,?,?)}");
       pst.setString(1,entreprise.getId_());
       pst.setString(2, entreprise.getDesignation_());
       pst.setString(3,entreprise.getRccm_());
       pst.setString(4,entreprise.getAdressPhysique_());
       pst.setString(5,entreprise.getAdressEmail_());
       pst.setString(6,entreprise.getContact());
      int test= pst.executeUpdate();
      if(test==1){
          return true;
      }
   } 
}

}